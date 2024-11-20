package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewDTO {

    @Getter
    public static class ReviewSaveRequestDTO{

        String content;

        Integer score;

    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewSaveResponseDTO{

        Long id;

    }
}
