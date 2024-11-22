package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.web.dto.ReviewDTO;

@Service
public interface ReviewService {
    ReviewDTO.ReviewSaveResponseDTO addReview(ReviewDTO.ReviewSaveRequestDTO request,
                                              Long memberId,
                                              Long storeId);
}
