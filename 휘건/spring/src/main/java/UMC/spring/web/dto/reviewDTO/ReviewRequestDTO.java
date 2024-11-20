package UMC.spring.web.dto.reviewDTO;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {

        
        @NotNull(message = "회원ID는 필수 값입니다.")
        private Long memberId;

        @NotBlank
        @Size(max = 300)
        private String content;

        @DecimalMin(value = "1.0")
        @DecimalMax(value = "5.0")
        private BigDecimal rate;

    }
}
