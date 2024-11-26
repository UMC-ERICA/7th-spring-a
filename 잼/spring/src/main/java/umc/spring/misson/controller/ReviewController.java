package umc.spring.misson.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.misson.annotation.custom.CustomPage;
import umc.spring.misson.dto.review.ReviewRequestDto;
import umc.spring.misson.dto.review.ReviewResponseDto;
import umc.spring.misson.repository.UserMissionRepository.service.ReviewQueryService;
import umc.spring.misson.repository.UserMissionRepository.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewQueryService reviewQueryService;

    /**
     * 리뷰 저장
     */
    @PostMapping
    public ResponseEntity<ReviewResponseDto> addReview(
            @PathVariable Long userId,
            @RequestBody @Valid ReviewRequestDto dto) {
        return ResponseEntity.ok(reviewService.plusReview(userId, dto));
    }

    /**
     * 모든 리뷰 목록 조회 (페이징 처리)
     *
     * @param page 페이지 번호 (쿼리 스트링)
     * @return ResponseEntity<Page < ReviewResponseDto>> 페이징된 리뷰 목록
     */
    @GetMapping
    @Operation(summary = "모든 리뷰를 조회합니다.", description = "리뷰 목록을 페이지네이션하여 조회합니다. 한 페이지에 10개씩 조회됩니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "리뷰 목록 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ReviewResponseDto.class)))),
            @ApiResponse(responseCode = "400", description = "잘못된 페이지 번호", content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<Page<ReviewResponseDto>> getAllReviews(
            @RequestParam(name = "page") @CustomPage Integer page) {
        Page<ReviewResponseDto> allReviews = reviewQueryService.getAllReviews(page);
        return ResponseEntity.ok(allReviews);
    }

    /**
     * 특정 리뷰 조회
     * @param id 리뷰 ID
     * @return ReviewFindDTO 특정 리뷰의 DTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReviewById(@PathVariable Long id) {
        ReviewResponseDto review = reviewService.getReviewById(id);  // 서비스에서 특정 리뷰 조회
        return ResponseEntity.ok(review);  // HTTP 200 OK로 반환
    }
}
