package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionDTO {

    @Getter
    public static class MissionRequestDTO{

        String content;

        Integer point;

        LocalDate deadLine;

    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionResponseDTO{
        Long id;
    }
}
