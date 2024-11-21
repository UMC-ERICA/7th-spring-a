package UMC.spring.repository.memberMissionRepository;


import UMC.spring.domain.enums.MissionStatus;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MemberMissionRepositoryCustom {

    Page<MemberMissionDTO> findMissionByStatus(Long memberId, MissionStatus missionStatus, Pageable pageable);

    Page<MemberMissionDTO> findAvailableMissions(Long memberId, Pageable pageable);

    Integer calculateCompletedMissionRemainder(Long memberId);
}
