package umc.spring.example.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.example.domain.Member;
import umc.spring.example.domain.mapping.Review;
import umc.spring.example.domain.mapping.Store;
import umc.spring.example.dto.ReviewDTO;
import umc.spring.example.exception.MemberNotFoundException;
import umc.spring.example.exception.StoreNotFoundException;
import umc.spring.example.repository.memberRepository.MemberRepository;
import umc.spring.example.repository.reviewRepository.ReviewRepository;
import umc.spring.example.repository.storeRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public void insertReview(ReviewDTO reviewDTO) {

        // Member와 Store 엔티티 조회
        Member member = memberRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new MemberNotFoundException("멤버가 존재하지 않습니다."));
        Store store = storeRepository.findById(reviewDTO.getStoreId())
                .orElseThrow(() -> new StoreNotFoundException("가게가 존재하지 않습니다."));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .content(reviewDTO.getContent())
                .rating(reviewDTO.getRating())
                .build();

        reviewRepository.save(review);
    }

}
