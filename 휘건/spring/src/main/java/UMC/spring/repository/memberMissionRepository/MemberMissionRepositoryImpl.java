package UMC.spring.repository.memberMissionRepository;

import UMC.spring.domain.Mission;
import UMC.spring.domain.QMember;
import UMC.spring.domain.QMission;
import UMC.spring.domain.QStore;
import UMC.spring.domain.enums.MissionStatus;
import UMC.spring.domain.mapping.QMemberMission;
import UMC.spring.web.dto.MemberMissionDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QMember member = QMember.member;
    private final QStore store = QStore.store;


    @Override
    public Page<MemberMissionDTO> findMissionByStatus(Long memberId, MissionStatus missionStatus, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.missionStatus.eq(missionStatus));

        List<MemberMissionDTO> missionList = jpaQueryFactory
                .select(Projections.fields(MemberMissionDTO.class,
                        memberMission.id.as("memberMissionId"),
                        memberMission.missionStatus,
                        mission.content,
                        mission.rewardPoint))
                .from(memberMission)
                .leftJoin(memberMission.mission, mission)
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = Optional.ofNullable(jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(predicate)
                .fetchOne()).orElse(0L);

        return new PageImpl<>(missionList, pageable, total);
    }

    @Override
    public Page<MemberMissionDTO> findAvailableMissions(Long memberId, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(member.id.eq(memberId));

        String memberNeighborhood = jpaQueryFactory
                .select(member.region.neighborhood)
                .from(member)
                .where(predicate)
                .fetchOne();

        predicate.and(mission.store.region.neighborhood.eq(memberNeighborhood));
        predicate.and(mission.id.notIn(
                JPAExpressions
                        .select(memberMission.mission.id)
                        .from(memberMission)
                        .where(memberMission.member.id.eq(memberId))
        ));

        List<MemberMissionDTO> missionList = jpaQueryFactory
                .select(Projections.fields(MemberMissionDTO.class,
                        mission.id.as("missionId"),
                        mission.content,
                        mission.rewardPoint
                ))
                .from(mission)
                .leftJoin(mission.store, store)
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


        long total = Optional.ofNullable(jpaQueryFactory
                .select(mission.count())
                .from(mission)
                .leftJoin(mission.store, store)
                .where(predicate)
                .fetchOne()).orElse(0L);

        return new PageImpl<>(missionList, pageable, total);


    }

    @Override
    public Integer calculateCompletedMissionRemainder(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(member.id.eq(memberId));
        predicate.and(memberMission.missionStatus.eq(MissionStatus.COMPLETED));

        long completedMissionCount = Optional.ofNullable(jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(predicate)
                .fetchOne()).orElse(0L);

        return (int) (completedMissionCount % 10);
    }


}

