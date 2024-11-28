package UMC.spring.web.dto.missionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class CreateMissionResultDTO {

        Long missionId;

        LocalDateTime createdAt;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class StoreMissionPreviewDTO {

        String storeName;
        Integer reward;
        String content;
        LocalDate expiredDate;
        LocalDate createdAt;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class StoreMissionPreviewListDTO {

        List<StoreMissionPreviewDTO> storeMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;

    }




}
