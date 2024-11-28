package UMC.spring.web.controller;

import UMC.spring.api.ApiResponse;
import UMC.spring.converter.MemberConverter;
import UMC.spring.converter.MemberMissionConverter;
import UMC.spring.converter.ReviewConverter;
import UMC.spring.domain.Member;
import UMC.spring.domain.Review;
import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.service.memberMissionService.MemberMissionCommandService;
import UMC.spring.service.memberMissionService.MemberMissionQueryService;
import UMC.spring.service.memberService.MemberCommandService;
import UMC.spring.service.reviewService.ReviewQueryService;
import UMC.spring.validation.annotation.ExistMission;
import UMC.spring.validation.annotation.PageValid;
import UMC.spring.web.dto.memberDTO.MemberRequestDTO;
import UMC.spring.web.dto.memberDTO.MemberResponseDTO;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionResponseDTO;
import UMC.spring.web.dto.reviewDTO.ReviewResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Tag(name = "Member API", description = "member와 관련된 전반적인 API 모음입니다.")
@Validated
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final ReviewQueryService reviewQueryService;
    private final MemberMissionQueryService memberMissionQueryService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    @Operation(summary = "회원가입 API", description = "멤버 회원 가입 API입니다.")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }



    @GetMapping("/member/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록API", description = "멤버가 작성한 리뷰 목록을 페이징해서 조회하는 API입니다.")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewListByMember(
            @PathVariable Long memberId,
            @PageValid @RequestParam (defaultValue = "1") Integer page
    ) {

        Page<Review> reviewPage = reviewQueryService.getReviewListByMember(memberId, page);

        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDTO(reviewPage));
    }

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "회원이 진행중인 미션 조회 API", description = "멤버가 진행중인 미션에 대해 페이징하여 조회하는 API입니다. (미션 전체가 아닌 진행중인 미션만 해당합니다)")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreviewListDTO> getMemberMissionListByMember(
            @PathVariable Long memberId,
            @PageValid @RequestParam(defaultValue = "1") Integer page
    ) {
        Page<MemberMission> memberMissionPage = memberMissionQueryService.getInProgressMissionByMember(memberId, page);

        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionPreviewListDTO(memberMissionPage));
    }

    @PatchMapping("/{memberId}/missions/{missionId}/status/completed")
    @Operation(summary = "진행 중 미션 성공 API", description = "회원이 진행중인 미션이 성공이 될 때 사용되는 API입니다.")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreviewDTO> updateMissionStatusCompleted(
            @PathVariable Long memberId,
            @PathVariable @ExistMission Long missionId
    ) {
        MemberMission memberMission = memberMissionCommandService.updateMissionStatus(memberId, missionId);

        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionPreviewDTO(memberMission));
    }



}
