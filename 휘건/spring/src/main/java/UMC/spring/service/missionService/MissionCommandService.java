package UMC.spring.service.missionService;

import UMC.spring.domain.Mission;
import UMC.spring.web.dto.missionDTO.MissionRequestDTO;

public interface MissionCommandService {

    Mission CreateMission(MissionRequestDTO.CreateMissionDTO request, Long storeId);

}
