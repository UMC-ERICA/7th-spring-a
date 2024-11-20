package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.ReviewService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.ReviewDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/{memberId}")
    public ApiResponse<ReviewDTO.ReviewSaveResponseDTO> save(@RequestBody ReviewDTO.ReviewSaveRequestDTO requestDTO,
                                                             @PathVariable Long memberId,
                                                             @PathVariable @ExistStores Long storeId) {

        ReviewDTO.ReviewSaveResponseDTO result = reviewService.addReview(requestDTO, memberId, storeId);

        return ApiResponse.onSuccess(result);
    }
}
