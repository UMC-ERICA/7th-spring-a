package umc.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewDTO {

    @Getter
    public static class ReviewSaveRequestDTO{

        String content;

        @Min(0)
        @Max(5)
        Integer score;

    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewSaveResponseDTO{

        Long id;
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewResponseDTO{

        Long reviewId;

        String nickname;

        String content;

        LocalDateTime createdAt;

        List<ReviewImageResponseDTO> reviewImages;

        List<CommentResponseDTO.MyReviewCommentResponseDTO> reviewComments;

    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewImageResponseDTO{

        String imagePath;
    }
}
