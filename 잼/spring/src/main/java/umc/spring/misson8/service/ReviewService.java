package umc.spring.misson8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.misson8.converter.ReviewConverter;
import umc.spring.misson8.dto.review.ReviewRequestDto;
import umc.spring.misson8.dto.review.ReviewResponseDto;
import umc.spring.misson8.entity.restaurant.Restaurant;
import umc.spring.misson8.entity.review.Review;
import umc.spring.misson8.entity.user.User;
import umc.spring.misson8.exception.RestaurantNotFoundException;
import umc.spring.misson8.repository.RestaurantRepository;
import umc.spring.misson8.repository.ReviewRepository;
import umc.spring.misson8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ReviewConverter reviewConverter;

    @Transactional
    public ReviewResponseDto plusReview(Long userId, ReviewRequestDto dto) {

        // userId로 User 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));


        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        Review review = reviewConverter.convertToEntity(dto, restaurant, user);
        Review savedReview = reviewRepository.save(review);

        return reviewConverter.convertToDto(savedReview);


    }
}
