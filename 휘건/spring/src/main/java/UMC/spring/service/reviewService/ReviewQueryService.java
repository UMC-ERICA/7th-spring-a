package UMC.spring.service.reviewService;

import UMC.spring.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {

    Page<Review> getReviewListByStore(Long storeId, Integer page);
    Page<Review> getReviewListByMember(Long memberId, Integer page);
}
