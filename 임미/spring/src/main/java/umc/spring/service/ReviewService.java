package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.web.dto.ReviewDTO;

import java.util.List;

@Service
public interface ReviewService {
    ReviewDTO.ReviewSaveResponseDTO addReview(ReviewDTO.ReviewSaveRequestDTO request,
                                              Long memberId,
                                              Long storeId);

    List<ReviewDTO.ReviewResponseDTO> findReviewById(Long memberId, Long storeId, Integer page);

    List<ReviewDTO.ReviewResponseDTO> findReviewByStoreId(Long storeId, Integer page);
}
