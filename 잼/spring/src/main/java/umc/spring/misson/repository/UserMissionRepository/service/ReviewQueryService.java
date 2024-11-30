package umc.spring.misson.repository.UserMissionRepository.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.misson.annotation.custom.CustomPage;
import umc.spring.misson.dto.review.ReviewResponseDto;
import umc.spring.misson.entity.review.Review;
import umc.spring.misson.repository.reviewRepository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    /**
     * 제목으로 리뷰 검색
     *
     * @param title 제목 기준으로 리뷰 검색
     * @return List<ReviewResponseDto> 제목에 해당하는 리뷰 목록
     */
    public List<ReviewResponseDto> searchReviewsByTitle(String title) {
        List<Review> reviews = reviewRepository.findByTitle(title);
        return reviews.stream()
                .map(ReviewResponseDto::new)
                .collect(Collectors.toList());
    }


    /**
     * 페이지 번호를 받아서 페이징된 리뷰 목록 조회
     *
     * @param page 페이지 번호 (쿼리 스트링으로 전달됨)
     * @return List<ReviewResponseDto> 페이징된 리뷰 목록
     */
    public Page<ReviewResponseDto> getAllReviews(@CustomPage Integer page) {

        //page가 1일 경우 0으로 변경
        page = (page > 0) ? page - 1 : 0;

        Pageable pageable = PageRequest.of(page, 10, Sort.by("createAt").descending());
        Page<Review> reviews = reviewRepository.findAll(pageable);

        return reviews.map(ReviewResponseDto::new);
    }
}
