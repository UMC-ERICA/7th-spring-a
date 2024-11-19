package UMC.spring.service.reviewService;

import UMC.spring.domain.Review;
import UMC.spring.web.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {

    Review CreateReview(ReviewRequestDTO.CreateReviewDTO request, Long storeId);
}
