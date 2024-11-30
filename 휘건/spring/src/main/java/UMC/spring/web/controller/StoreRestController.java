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
import UMC.spring.service.memberMissionService.MemberMissionCommandService;
import UMC.spring.service.missionService.MissionCommandService;
import UMC.spring.service.missionService.MissionQueryService;
import UMC.spring.service.reviewService.ReviewCommandService;
import UMC.spring.service.reviewService.ReviewQueryService;
import UMC.spring.service.storeService.StoreCommandService;
import UMC.spring.validation.annotation.ExistMission;
import UMC.spring.validation.annotation.ExistStore;
import UMC.spring.validation.annotation.PageValid;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionRequestDTO;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionResponseDTO;
import UMC.spring.web.dto.missionDTO.MissionRequestDTO;
import UMC.spring.web.dto.missionDTO.MissionResponseDTO;
import UMC.spring.web.dto.reviewDTO.ReviewRequestDTO;
import UMC.spring.web.dto.reviewDTO.ReviewResponseDTO;
import UMC.spring.web.dto.storeDTO.StoreRequestDTO;
import UMC.spring.web.dto.storeDTO.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Tag(name = "Store API", description = "store와 관련된 전반적인 API 모음입니다.")
@Validated
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;
    private final ReviewQueryService reviewQueryService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    @Operation(summary = "가게 등록 API", description = "가게를 등록하는 API입니다.")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {
        Store store = storeCommandService.CreateStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }


    @PostMapping("/{storeId}/reviews")
    @Operation(summary = "리뷰 작성 API", description = "해당 가게에 리뷰를 작성하는 API입니다.")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(
            @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO request,
            @PathVariable @ExistStore Long storeId
            ) {
        Review review = reviewCommandService.CreateReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    @Operation(summary = "미션 등록 API", description = "해당 가게에 미션을 등록하는 API입니다.")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request,
            @PathVariable @ExistStore Long storeId
            ) {
        Mission mission = missionCommandService.CreateMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }

    @PostMapping("/{storeId}/missions/{missionId}/challenge")
    @Operation(summary = "미션 도전 API", description = "해당 가게에 있는 미션을 도전하는 API입니다.")
    public ApiResponse<MemberMissionResponseDTO.CreateMemberMissionResultDTO> createMemberMission(
            @RequestBody @Valid MemberMissionRequestDTO.CreateMemberMissionDTO request,
            @PathVariable @ExistStore Long storeId,
            @PathVariable @ExistMission Long missionId
            ) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(request, storeId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateMemberMissionResultDTO(memberMission));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "리뷰 조회 API", description = "리뷰를 페이징해서 조회하는 API입니다.")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewListByStore(
            @PathVariable @ExistStore Long storeId,
            @PageValid @RequestParam(defaultValue = "1") Integer page
    ) {

        Page<Review> reviewPage = reviewQueryService.getReviewListByStore(storeId, page);

        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDTO(reviewPage));
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "가게 미션 조회 API", description = "해당 가게에 속해있는 미션을 페이징해서 조회하는 API입니다.")
    public ApiResponse<MissionResponseDTO.StoreMissionPreviewListDTO> getMissionByStore(
            @PathVariable @ExistStore Long storeId,
            @PageValid @RequestParam(defaultValue = "1") Integer page
    ) {
        Page<Mission> missionPage = missionQueryService.getMissionListByStore(storeId, page);

        return ApiResponse.onSuccess(MissionConverter.toStoreMissionPreviewListDTO(missionPage));
    }

}
