package umc.spring.repository.memberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mission.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
