package umc.spring.misson.dto.review;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.misson.entity.review.Review;
import umc.spring.misson.entity.review.ReviewImage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {

    @Schema(description = "사용자 이름", example = "닉네임1234")
    private String userName;

    @Schema(description = "리뷰 내용", example = "음 너무 맛있어요.")
    private String comment;

    @Schema(description = "리뷰 별점", example = "4.5")
    private int rating;

    @Schema(description = "리뷰 이미지 URL 목록")
    private List<String> reviewImages;

    @Schema(description = "리뷰 생성일", example = "2024-11-26T13:45:00")
    private LocalDateTime createAt;

    @Schema(description = "리뷰 수정일", example = "2024-11-27T10:00:00")
    private LocalDateTime updateAt;


    public ReviewResponseDto(Review review) {
        this.userName = review.getUser().getName();  // User 엔티티에서 이름을 가져옴
        this.comment = review.getComment();  // 리뷰 내용
        this.rating = review.getRating();  // 별점
        this.createAt = review.getCreateAt();  // 생성일
        this.updateAt = review.getUpdateAt();  // 수정일

        // ReviewImage 경로 리스트를 가져옴
        this.reviewImages = review.getReviewImages().stream()
                .map(ReviewImage::getReviewPath)  // ReviewImage의 경로 가져오기
                .collect(Collectors.toList());
    }
}
