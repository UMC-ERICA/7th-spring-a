package UMC.spring.converter;

import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
public class MemberMissionConverter {


    public static MemberMissionResponseDTO.CreateMemberMissionResultDTO toCreateMemberMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.CreateMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getId())
                .storeId(memberMission.getMission().getStore().getId())
                .storeName(memberMission.getMission().getStore().getStoreName())
                .storeCategory(memberMission.getMission().getStore().getStoreCategory().toString())
                .missionId(memberMission.getMission().getId())
                .content(memberMission.getMission().getContent())
                .reward(memberMission.getMission().getRewardPoint())
                .missionStatus(memberMission.getMissionStatus().toString())
                .expirationDate(memberMission.getMission().getExpirationDate())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }


}

