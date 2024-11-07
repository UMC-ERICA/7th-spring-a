package UMC.spring.repository.memberMissionRepository;


import UMC.spring.domain.enums.MissionStatus;
import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.web.dto.MemberMissionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MemberMissionRepositoryCustom {

    Page<MemberMissionDTO> findMissionByStatus(Long memberId, MissionStatus missionStatus, Pageable pageable);

}
