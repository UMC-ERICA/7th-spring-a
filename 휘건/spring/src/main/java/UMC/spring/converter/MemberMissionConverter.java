package UMC.spring.converter;

import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;


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


    public static MemberMissionResponseDTO.MemberMissionPreviewDTO toMemberMissionPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .memberName(memberMission.getMember().getMemberName())
                .content(memberMission.getMission().getContent())
                .reward(memberMission.getMission().getRewardPoint())
                .missionStatus(memberMission.getMissionStatus().toString())
                .expirationDate(memberMission.getMission().getExpirationDate())
                .createdAt(memberMission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewListDTO toMemberMissionPreviewListDTO(Page<MemberMission> memberMissionPage) {

        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> memberMissionList = memberMissionPage.getContent().stream()
                .map(MemberMissionConverter::toMemberMissionPreviewDTO)
                .toList();

        return MemberMissionResponseDTO.MemberMissionPreviewListDTO.builder()
                .memberMissionList(memberMissionList)
                .listSize(memberMissionList.size())
                .totalPage(memberMissionPage.getTotalPages())
                .totalElements(memberMissionPage.getTotalElements())
                .isFirst(memberMissionPage.isFirst())
                .isLast(memberMissionPage.isLast())
                .build();
    }


}

