package UMC.spring.service.reviewService;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.MemberHandler;
import UMC.spring.api.exception.handler.StoreHandler;
import UMC.spring.domain.Member;
import UMC.spring.domain.Review;
import UMC.spring.domain.Store;
import UMC.spring.repository.memberRepository.MemberRepository;
import UMC.spring.repository.reviewRepository.ReviewRepository;
import UMC.spring.repository.storeRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;



    @Override
    public Page<Review> getReviewListByStore(Long storeId, Integer page) {

        int validatePage = page - 1;

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        return reviewRepository.findAllByStore(store, PageRequest.of(validatePage, 10));
    }

    @Override
    public Page<Review> getReviewListByMember(Long memberId, Integer page) {

        int validatePage = page - 1;

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return reviewRepository.findAllByMember(member, PageRequest.of(validatePage,10));
    }


}
