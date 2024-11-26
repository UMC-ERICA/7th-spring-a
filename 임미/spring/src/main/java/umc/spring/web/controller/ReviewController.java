package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.ReviewService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.ReviewDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.util.List;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
@Tag(name = "리뷰관련 API")
public class ReviewController {


    private final ReviewService reviewService;


    @PostMapping("/storeId/{storeId}/memberId/{memberId}")
    public ApiResponse<ReviewDTO.ReviewSaveResponseDTO> save(@RequestBody ReviewDTO.ReviewSaveRequestDTO requestDTO,
                                                             @PathVariable Long memberId,
                                                             @ExistStores @PathVariable Long storeId) {

        ReviewDTO.ReviewSaveResponseDTO result = reviewService.addReview(requestDTO, memberId, storeId);

        return ApiResponse.onSuccess(result);
    }


    // 특정 가게의 리뷰
    @Operation(summary = "특정 가게의 리뷰 조회 API")
    @GetMapping("/storeId/{storeId}")
    private void getReviewStore(@PathVariable Long storeId) {

    }


    // 내가 작성한 리뷰 목록
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API")
    @GetMapping("/storeId/{storeId}/memberId/{memberId}")
    private ApiResponse<List<ReviewDTO.ReviewResponseDTO>> getReviewStore(@PathVariable Long storeId,
                                                                    @PathVariable Long memberId,
                                                                    @RequestParam Integer page) {

        List<ReviewDTO.ReviewResponseDTO> result = reviewService.findReviewById(memberId, storeId, page);

        return ApiResponse.onSuccess(result);
    }
}
