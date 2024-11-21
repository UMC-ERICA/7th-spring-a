package UMC.spring.service.reviewService;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.MemberHandler;
import UMC.spring.api.exception.handler.StoreHandler;
import UMC.spring.converter.ReviewConverter;
import UMC.spring.domain.Member;
import UMC.spring.domain.Review;
import UMC.spring.domain.Store;
import UMC.spring.repository.memberRepository.MemberRepository;
import UMC.spring.repository.reviewRepository.ReviewRepository;
import UMC.spring.repository.storeRepository.StoreRepository;
import UMC.spring.web.dto.reviewDTO.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review CreateReview(ReviewRequestDTO.CreateReviewDTO request, Long storeId) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, member, store);

        store.updateStoreRate(request.getRate());
        reviewRepository.save(review);

        return review;
    }
}
