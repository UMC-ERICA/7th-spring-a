package umc.spring.misson8.converter;

import org.springframework.stereotype.Component;
import umc.spring.misson8.dto.review.ReviewRequestDto;
import umc.spring.misson8.dto.review.ReviewResponseDto;
import umc.spring.misson8.entity.restaurant.Restaurant;
import umc.spring.misson8.entity.review.Review;
import umc.spring.misson8.entity.review.ReviewImage;
import umc.spring.misson8.entity.user.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewConverter {
    public Review convertToEntity(ReviewRequestDto dto, Restaurant restaurant, User user) {
        // Review 생성
        Review review = Review.builder()
                .user(user) // User 설정
                .restaurant(restaurant) // Restaurant 설정
                .rating(dto.getRating()) // Rating 설정
                .comment(dto.getComment()) // Comment 설정
                .build();

        // ReviewImage 처리
        if (dto.getReviewImage() != null) {
            ReviewImage image = new ReviewImage();
            image.setReviewPath(dto.getReviewImage().getReviewPath());
            review.getReviewImages().add(image);
        }
        return review;
    }

    public ReviewResponseDto convertToDto(Review review) {
        List<String> imagePaths = review.getReviewImages()
                .stream()
                .map(ReviewImage::getReviewPath)
                .collect(Collectors.toList());

        return new ReviewResponseDto(
                review.getId(),
                review.getComment(),
                review.getRating(),
                review.getRestaurant().getName(),
                review.getUser().getName(),
                imagePaths
        );
    }
}
