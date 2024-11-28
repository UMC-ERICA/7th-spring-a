package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.service.StoreService;
import umc.spring.web.dto.StoreDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {


    private final StoreService storeService;


    @PostMapping
    public ApiResponse<StoreDTO.StoreSaveResponseDTO> save(@RequestBody StoreDTO.StoreSaveRequestDTO storeSaveRequestDTO) {

        StoreDTO.StoreSaveResponseDTO result = storeService.save(storeSaveRequestDTO);

        return ApiResponse.onSuccess(result);
    }


}
