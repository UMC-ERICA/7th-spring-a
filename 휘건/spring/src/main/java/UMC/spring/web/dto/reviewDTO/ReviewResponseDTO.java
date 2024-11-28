package UMC.spring.web.dto.reviewDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class CreateReviewResultDTO {
        Long reviewId;
        LocalDateTime createdAt;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class ReviewPreviewDTO {
        String ownerNickname;
        BigDecimal rate;
        String content;
        LocalDate createdAt;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class ReviewPreviewListDTO {

        List<ReviewPreviewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;

    }
}
