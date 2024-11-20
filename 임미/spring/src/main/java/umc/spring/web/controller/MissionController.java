package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.MissionService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionDTO.MissionResponseDTO> saveMission(@RequestBody MissionDTO.MissionRequestDTO request,
                                                                  @PathVariable @ExistStores Long storeId){

        MissionDTO.MissionResponseDTO result = missionService.saveMission(request, storeId);

        return ApiResponse.onSuccess(result);
    }

}
