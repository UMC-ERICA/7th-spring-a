package UMC.spring.service.memberMissionService;


import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionRequestDTO;

public interface MemberMissionCommandService {

    MemberMission createMemberMission(MemberMissionRequestDTO.CreateMemberMissionDTO request, Long storeId, Long missionId);

    MemberMission updateMissionStatus(Long memberId, Long missionId);

}
