package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreDTO {

    @Getter
    public static class StoreSaveRequestDTO{

        String name;

        LocalDateTime startTime;

        LocalDateTime endTime;

        /* 시/도 */
        String province;

        /* 시/군/구 */
        String city;

        /* 읍/면/동 */
        String town;

        /* 상세주소 */
        String detail;


    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreSaveResponseDTO{

        Long id;
    }
}
