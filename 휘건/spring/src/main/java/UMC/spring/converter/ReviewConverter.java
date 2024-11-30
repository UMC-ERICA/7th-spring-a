package UMC.spring.converter;

import UMC.spring.domain.Member;
import UMC.spring.domain.Review;
import UMC.spring.domain.Store;
import UMC.spring.web.dto.reviewDTO.ReviewRequestDTO;
import UMC.spring.web.dto.reviewDTO.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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


    public static ReviewResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review) {

        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getMemberName())
                .content(review.getContent())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewPage) {

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewList = reviewPage.getContent().stream()
                .map(ReviewConverter::toReviewPreviewDTO)
                .toList();

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .reviewList(reviewList)
                .listSize(reviewList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}
