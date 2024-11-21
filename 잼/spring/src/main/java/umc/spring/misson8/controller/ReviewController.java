package umc.spring.misson8.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.misson8.dto.review.ReviewRequestDto;
import umc.spring.misson8.dto.review.ReviewResponseDto;
import umc.spring.misson8.service.ReviewService;

@RestController
@RequestMapping("/api/users/{userId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> addReview(
            @PathVariable Long userId,
            @RequestBody @Valid ReviewRequestDto dto) {
        return ResponseEntity.ok(reviewService.plusReview(userId, dto));
    }
}
