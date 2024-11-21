package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.MemberMissionService;
import umc.spring.web.dto.MemberResponseDTO;

@RestController
@RequestMapping("/member-missions")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/{missionId}/{memberId}")
    public ApiResponse<MemberResponseDTO.MemberMissionResponseDTO> addMemberMission(@PathVariable Long missionId,
                                                                                    @PathVariable Long memberId) {

        MemberResponseDTO.MemberMissionResponseDTO result = memberMissionService.addMemberMission(missionId, memberId);

        return ApiResponse.onSuccess(result);
    }
}
