package UMC.spring.repository.memberMissionRepository;

import UMC.spring.domain.QMission;
import UMC.spring.domain.enums.MissionStatus;
import UMC.spring.domain.mapping.QMemberMission;
import UMC.spring.web.dto.MemberMissionDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
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

    @Override
    public Page<MemberMissionDTO> findMissionByStatus(Long memberId, MissionStatus missionStatus, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(memberMission.member.id.eq(memberId));    // 회원 id를 통한 필터링
        predicate.and(memberMission.missionStatus.eq(missionStatus));   // 미션 상태 필터링

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
}

