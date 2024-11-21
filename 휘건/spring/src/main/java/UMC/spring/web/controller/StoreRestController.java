package UMC.spring.web.controller;

import UMC.spring.api.ApiResponse;
import UMC.spring.converter.MemberMissionConverter;
import UMC.spring.converter.MissionConverter;
import UMC.spring.converter.ReviewConverter;
import UMC.spring.converter.StoreConverter;
import UMC.spring.domain.Mission;
import UMC.spring.domain.Review;
import UMC.spring.domain.Store;
import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.service.memberMissionService.MemberMissionService;
import UMC.spring.service.missionService.MissionCommandService;
import UMC.spring.service.reviewService.ReviewCommandService;
import UMC.spring.service.storeService.StoreCommandService;
import UMC.spring.validation.annotation.ExistMission;
import UMC.spring.validation.annotation.ExistStore;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionRequestDTO;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionResponseDTO;
import UMC.spring.web.dto.missionDTO.MissionRequestDTO;
import UMC.spring.web.dto.missionDTO.MissionResponseDTO;
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
    private final MissionCommandService missionCommandService;
    private final MemberMissionService memberMissionService;

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

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request,
            @PathVariable @ExistStore Long storeId
            ) {
        Mission mission = missionCommandService.CreateMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }

    @PostMapping("/{storeId}/missions/{missionId}/challenge")
    public ApiResponse<MemberMissionResponseDTO.CreateMemberMissionResultDTO> createMemberMission(
            @RequestBody @Valid MemberMissionRequestDTO.CreateMemberMissionDTO request,
            @PathVariable @ExistStore Long storeId,
            @PathVariable @ExistMission Long missionId
            ) {
        MemberMission memberMission = memberMissionService.CreateMemberMission(request, storeId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateMemberMissionResultDTO(memberMission));
    }
}
