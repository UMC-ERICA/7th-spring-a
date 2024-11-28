package UMC.spring.converter;

import UMC.spring.domain.Mission;
import UMC.spring.domain.Review;
import UMC.spring.domain.Store;
import UMC.spring.web.dto.missionDTO.MissionRequestDTO;
import UMC.spring.web.dto.missionDTO.MissionResponseDTO;
import UMC.spring.web.dto.reviewDTO.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

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
                .expirationDate(request.getExpirationDate())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.StoreMissionPreviewDTO toStoreMissionPreviewDTO(Mission mission) {

        return MissionResponseDTO.StoreMissionPreviewDTO.builder()
                .storeName(mission.getStore().getStoreName())
                .reward(mission.getRewardPoint())
                .content(mission.getContent())
                .expiredDate(mission.getExpirationDate())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.StoreMissionPreviewListDTO toStoreMissionPreviewListDTO(Page<Mission> missionPage) {

        List<MissionResponseDTO.StoreMissionPreviewDTO> missionList = missionPage.getContent().stream()
                .map(MissionConverter::toStoreMissionPreviewDTO)
                .toList();

        return MissionResponseDTO.StoreMissionPreviewListDTO.builder()
                .storeMissionList(missionList)
                .listSize(missionList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();

    }
}
