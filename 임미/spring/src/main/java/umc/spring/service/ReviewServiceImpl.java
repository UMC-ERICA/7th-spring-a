package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.domain.member.Member;
import umc.spring.domain.store.Store;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.ReviewDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewDTO.ReviewSaveResponseDTO addReview(ReviewDTO.ReviewSaveRequestDTO request,
                                                     Long memberId,
                                                     Long storeId){


        Member memberById = memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("회원을 찾을 수 없습니다"));


        Store storeById = storeRepository.findById(storeId)
                .orElseThrow(()->new RuntimeException("상점을 찾을 수 없습니다"));


        Review review = Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .member(memberById)
                .store(storeById)
                .build();

        reviewRepository.save(review);

        return ReviewDTO.ReviewSaveResponseDTO.builder()
                .id(review.getId())
                .build();

    }
}
