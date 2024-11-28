package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.mission.Mission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
