package umc.spring.repository.memberMissionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.member.QMember;
import umc.spring.domain.mission.QMemberMission;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepository {

    QMemberMission memberMission = QMemberMission.memberMission;
    QMember member = QMember.member;


}
