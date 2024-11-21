package UMC.spring.web.dto.memberMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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



}
