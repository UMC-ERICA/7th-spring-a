package umc.spring.misson.repository.reviewRepository;

import umc.spring.misson.entity.review.Review;

import java.util.List;

public interface ReviewRepositoryCustom {

    /**
     * 제목으로 리뷰 검색
     * @param title
     * @return List<Review> 제목을 포함하는 리뷰 목록
     */
    List<Review> findByTitle(String title);

    /**
     모든 리뷰를 조회하는 메서드
     * @return List<Review> 모든 리뷰 목록
     */
    List<Review> findAllReviews();
}
