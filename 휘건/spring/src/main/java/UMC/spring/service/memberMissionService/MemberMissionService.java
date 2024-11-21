package UMC.spring.service.memberMissionService;


import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionRequestDTO;

public interface MemberMissionService {

    MemberMission CreateMemberMission(MemberMissionRequestDTO.CreateMemberMissionDTO request,Long storeId, Long missionId);

}
