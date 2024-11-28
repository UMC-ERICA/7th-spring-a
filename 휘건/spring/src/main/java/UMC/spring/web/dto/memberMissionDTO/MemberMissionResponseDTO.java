package UMC.spring.web.dto.memberMissionDTO;

import UMC.spring.web.dto.missionDTO.MissionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class CreateMemberMissionResultDTO {

        Long memberMissionId;
        Long memberId;
        Long storeId;
        String storeName;
        String storeCategory;
        Long missionId;
        String content;
        Integer reward;
        String missionStatus;
        LocalDate expirationDate;
        LocalDateTime createdAt;

    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MemberMissionPreviewDTO {

        String memberName;
        String content;
        Integer reward;
        String missionStatus;
        LocalDate expirationDate;
        LocalDate createdAt;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MemberMissionPreviewListDTO {

        List<MemberMissionPreviewDTO> memberMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;

    }



}
