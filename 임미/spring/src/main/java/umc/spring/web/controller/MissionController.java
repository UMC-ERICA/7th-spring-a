package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.MissionService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Tag(name = "미션 관리 API")
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/storeId/{storeId}")
    public ApiResponse<MissionDTO.MissionResponseDTO> saveMission(@RequestBody @Valid MissionDTO.MissionRequestDTO request){

        MissionDTO.MissionResponseDTO result = missionService.saveMission(request);

        return ApiResponse.onSuccess(result);
    }

}
