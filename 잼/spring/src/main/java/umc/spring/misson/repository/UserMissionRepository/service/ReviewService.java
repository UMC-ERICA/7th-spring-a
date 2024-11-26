package umc.spring.misson.repository.UserMissionRepository.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.misson.converter.ReviewConverter;
import umc.spring.misson.dto.review.ReviewRequestDto;
import umc.spring.misson.dto.review.ReviewResponseDto;
import umc.spring.misson.entity.restaurant.Restaurant;
import umc.spring.misson.entity.review.Review;
import umc.spring.misson.entity.user.User;
import umc.spring.misson.exception.RestaurantNotFoundException;
import umc.spring.misson.repository.resaurantRepository.RestaurantRepository;
import umc.spring.misson.repository.reviewRepository.ReviewRepository;
import umc.spring.misson.repository.UserRepository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 모든 리뷰 목록 조회
     * @return List<ReviewFindDTO> 리뷰 목록 (DTO 형식)
     */
    public List<ReviewResponseDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll(); // 모든 리뷰를 조회
        return reviews.stream()
                .map(ReviewResponseDto::new)  // Review 엔티티를 DTO로 변환
                .collect(Collectors.toList());  // DTO 리스트 반환
    }

    /**
     * 특정 리뷰 조회
     * @param id 리뷰 ID
     * @return ReviewFindDTO 특정 리뷰의 DTO
     */
    public ReviewResponseDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Review ID: " + id));
        return new ReviewResponseDto(review);  // Review 엔티티를 DTO로 변환
    }



}

