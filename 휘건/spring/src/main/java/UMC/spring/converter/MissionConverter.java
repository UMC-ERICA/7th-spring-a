package UMC.spring.converter;

import UMC.spring.domain.Mission;
import UMC.spring.domain.Store;
import UMC.spring.web.dto.missionDTO.MissionRequestDTO;
import UMC.spring.web.dto.missionDTO.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {

        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDTO request, Store store) {

        return Mission.builder()
                .content(request.getContent())
                .rewardPoint(request.getReward())
                .store(store)
                .build();
    }
}
