package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.MemberCategoryHandler;
import umc.spring.apiPayLoad.exception.handler.StoreCategoryHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.member.Member;
import umc.spring.domain.store.Store;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.CommentResponseDTO;
import umc.spring.web.dto.ReviewDTO;

import java.util.List;
import java.util.stream.Collectors;

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

        Review review = ReviewConverter.toReview(request, memberById, storeById);

        reviewRepository.save(review);

        return ReviewDTO.ReviewSaveResponseDTO.builder()
                .id(review.getId())
                .build();

    }



    @Override
    public List<ReviewDTO.ReviewResponseDTO> findReviewById(Long memberId, Long storeId, Integer page){

        // size는 10으로 고정하고
        int size=10;

        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(()->new MemberCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store findStore = storeRepository.findById(storeId)
                .orElseThrow(()->new StoreCategoryHandler(ErrorStatus.STORE_NOT_FOUND));

        // pageable 객체를 생성하여, 1부터 시작하기 위해 -1
        Pageable pageable = PageRequest.of(page - 1, size);

        // 3. Page<Review> 조회
        Page<Review> reviews = reviewRepository.findByMemberAndStore(findMember, findStore, pageable);

        List<ReviewDTO.ReviewResponseDTO> result = ReviewConverter.toReviewResponseDTO(reviews);

        return result;

    }
}
