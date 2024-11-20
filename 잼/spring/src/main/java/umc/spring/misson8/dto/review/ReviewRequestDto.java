package umc.spring.misson8.dto.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRequestDto {

    @NotBlank(message = "내용을 입력해주세요.")
    private String comment;

    @NotNull(message = "평점을 달아주세요,")
    private Integer rating;


    private ReviewImageDto reviewImage;

    private Long restaurantId;


}
