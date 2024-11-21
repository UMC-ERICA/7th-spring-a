package UMC.spring.converter;

import UMC.spring.domain.Member;
import UMC.spring.domain.Review;
import UMC.spring.domain.Store;
import UMC.spring.web.dto.reviewDTO.ReviewRequestDTO;
import UMC.spring.web.dto.reviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {

        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateReviewDTO request, Member member, Store store) {

        return Review.builder()
                .member(member)
                .store(store)
                .rate(request.getRate())
                .content(request.getContent())
                .build();
    }
}
