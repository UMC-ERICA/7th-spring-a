package UMC.spring.repository.memberMissionRepository;

import UMC.spring.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long>, MemberMissionRepositoryCustom {

}
