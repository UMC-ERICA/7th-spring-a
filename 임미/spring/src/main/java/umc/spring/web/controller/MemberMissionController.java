package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.MemberMissionService;
import umc.spring.web.dto.MemberResponseDTO;

@RestController
@RequestMapping("/member-missions")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/missionId/{missionId}/memberId/{memberId}")
    public ApiResponse<MemberResponseDTO.MemberMissionResponseDTO> addMemberMission(@PathVariable Long missionId,
                                                                                    @PathVariable Long memberId) {

        MemberResponseDTO.MemberMissionResponseDTO result = memberMissionService.addMemberMission(missionId, memberId);

        return ApiResponse.onSuccess(result);
    }


    // 내가 진행중인 리뷰
    @Operation(summary = "내가 진행중인 리뷰 조회 API")
    @GetMapping("/missionId/{missionId}/memberId/{memberId}")
    public void getMyReview(@PathVariable Long missionId,
                            @PathVariable Long memberId){



    }


    // 진행중인 미션 진행 완료로 바꾸기
    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API")
    @PostMapping("/toggle/missionId/{missionId}/memberId/{memberId}")
    public void changeReviewStatus(@PathVariable Long missionId,
                            @PathVariable Long memberId){
    }
}