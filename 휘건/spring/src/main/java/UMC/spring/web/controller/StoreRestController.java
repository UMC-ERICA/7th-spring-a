package UMC.spring.web.controller;

import UMC.spring.api.ApiResponse;
import UMC.spring.converter.ReviewConverter;
import UMC.spring.converter.StoreConverter;
import UMC.spring.domain.Review;
import UMC.spring.domain.Store;
import UMC.spring.service.reviewService.ReviewCommandService;
import UMC.spring.service.storeService.StoreCommandService;
import UMC.spring.validation.annotation.ExistStore;
import UMC.spring.web.dto.reviewDTO.ReviewRequestDTO;
import UMC.spring.web.dto.reviewDTO.ReviewResponseDTO;
import UMC.spring.web.dto.storeDTO.StoreRequestDTO;
import UMC.spring.web.dto.storeDTO.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Validated
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {
        Store store = storeCommandService.CreateStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }


    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(
            @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO request,
            @PathVariable @ExistStore Long storeId
            ) {
        Review review = reviewCommandService.CreateReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }
}
