package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistStores;

import java.time.LocalDate;

public class MissionDTO {

    @Getter
    public static class MissionRequestDTO{

        String content;

        Integer point;

        LocalDate deadLine;

        @ExistStores
        Long storeId;

    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionResponseDTO{

        Long id;

    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberMissionResponseDTO{

        Long missionId;

        String content;

        Integer point;

    }
}
