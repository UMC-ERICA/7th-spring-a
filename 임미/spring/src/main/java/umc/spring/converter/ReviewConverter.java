package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImages;
import umc.spring.domain.member.Member;
import umc.spring.domain.store.Store;
import umc.spring.web.dto.CommentResponseDTO;
import umc.spring.web.dto.ReviewDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {


    public static Review toReview(ReviewDTO.ReviewSaveRequestDTO request, Member memberById, Store storeById) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .member(memberById)
                .store(storeById)
                .build();
    }


    public static List<ReviewDTO.ReviewResponseDTO> toReviewResponseDTO(Page<Review> reviews){

        return reviews.stream().map(
                        review -> ReviewDTO.ReviewResponseDTO.builder()
                                .reviewId(review.getId())
                                .nickname(review.getMember().getName())
                                .content(review.getContent())
                                .createdAt(review.getCreatedAt())
                                .reviewImages(ReviewConverter.toReviewImageResponseDTO(review))
                                .reviewComments(ReviewConverter.toMyReviewCommentResponseDTO(review))
                                .build())
                .collect(Collectors.toList());

    }


    public static List<ReviewDTO.ReviewImageResponseDTO> toReviewImageResponseDTO(Review review) {

        return review.getReviewImages().stream()
                .map(reviewImage -> ReviewDTO.ReviewImageResponseDTO.builder()
                        .imagePath(reviewImage.getPath() != null ? reviewImage.getPath() : "default Image")
                        .build())
                .collect(Collectors.toList());
    }


    public static List<CommentResponseDTO.MyReviewCommentResponseDTO> toMyReviewCommentResponseDTO(Review review) {

        return review.getReviewComments().stream()
                .map(reviewComment -> CommentResponseDTO.MyReviewCommentResponseDTO.builder()
                        .comment(reviewComment.getContent())
                        .createdAt(review.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
