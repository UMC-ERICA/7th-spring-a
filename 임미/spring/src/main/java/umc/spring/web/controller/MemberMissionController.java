package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.MemberMissionService;
import umc.spring.validation.annotation.PageValid;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MissionDTO;

import java.util.List;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

@RestController
@RequestMapping("/member-missions")
@RequiredArgsConstructor
@Validated
@Tag(name = "회원 미션 관리 API")
public class MemberMissionController {


    private final MemberMissionService memberMissionService;


    @PostMapping("/missionId/{missionId}/memberId/{memberId}")
    public ApiResponse<MemberResponseDTO.MemberMissionResponseDTO> addMemberMission(@PathVariable Long missionId,
                                                                                    @PathVariable Long memberId) {

        MemberResponseDTO.MemberMissionResponseDTO result = memberMissionService.addMemberMission(missionId, memberId);

        return ApiResponse.onSuccess(result);
    }


    // 내가 진행중인 리뷰
    @Operation(summary = "내가 진행중인 미션 조회 API")
    @GetMapping("/in-progress/memberId/{memberId}")
    public ApiResponse<List<MissionDTO.MemberMissionResponseDTO>> getMyReview(@PathVariable Long memberId,
                                                                              @RequestParam @PageValid Integer page){

        List<MissionDTO.MemberMissionResponseDTO> result = memberMissionService.getMemberMission(memberId, page);

        return ApiResponse.onSuccess(result);

    }


    // 진행중인 미션 진행 완료로 바꾸기
    @Operation(summary = "진행 완료된 미션 조회 API")
    @GetMapping("/done/memberId/{memberId}")
    public ApiResponse<List<MissionDTO.MemberMissionResponseDTO>> changeReviewStatus(@PathVariable Long memberId,
                                                                                     @RequestParam @PageValid Integer page){

        List<MissionDTO.MemberMissionResponseDTO> result = memberMissionService.getMemberMissionSuccess(memberId, page);

        return ApiResponse.onSuccess(result);

    }
}