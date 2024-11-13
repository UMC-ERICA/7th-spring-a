package umc.spring.repository.memberMissionRepository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.member.QMember;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.mission.QMemberMission;
import umc.spring.domain.mission.QMission;
import umc.spring.domain.store.QStore;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMember member = QMember.member;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    // 최근 멤버 미션 조회
    public List<MemberMission> findRecentMemberMissions(int n) {
        return jpaQueryFactory
                .selectFrom(memberMission)
                .join(memberMission.member, member)
                .orderBy(memberMission.createdAt.desc())
                .limit(3)
                .offset((n - 1) * 3)
                .fetch();
    }

    // 미션 성취도 조회
    public List<Tuple> findMissionAchievement(Long memberId) {
        NumberTemplate<Long> totalMissions = Expressions.numberTemplate(Long.class, "10");

        return jpaQueryFactory
                .select(
                        member.id,
                        member.point.as("user_point"),
                        memberMission.status.when(Boolean.valueOf("완료")).then(1).otherwise(0).sum().as("completed_missions"),
                        totalMissions.as("total_missions")
                )
                .from(member)
                .leftJoin(memberMission).on(member.id.eq(memberMission.member.id))
                .where(member.id.eq(memberId))
                .groupBy(member.id)
                .fetch();
    }

    // 미션 조회
    public List<Tuple> findAvailableMissions(Long memberId) {
        return jpaQueryFactory
                .select(
                        store.name.as("store_name"),
                        mission.content.as("mission_content"),
                        mission.point.as("mission_reward"),
                        Expressions.numberTemplate(Long.class, "datediff({0}, {1})", mission.deadline, Expressions.currentDate()).as("days_left")
                )
                .from(mission)
                .join(mission.store, store)
                .leftJoin(memberMission).on(mission.id.eq(memberMission.mission.id)
                        .and(memberMission.member.id.eq(memberId)))
                .where(memberMission.status.isNull().or(memberMission.status.ne(Boolean.valueOf("완료"))))
                .orderBy(mission.deadline.asc())
                .limit(2)
                .fetch();
    }
}