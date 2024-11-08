package umc.spring.repository.memberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.member.QMember;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.mission.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMember member = QMember.member;

    public List<MemberMission> findRecentMemberMissions(int n) {
        return jpaQueryFactory
                .selectFrom(memberMission)
                .join(memberMission.member, member)
                .orderBy(memberMission.createdAt.desc())
                .limit(3)
                .offset((n - 1) * 3)
                .fetch();
    }
}
