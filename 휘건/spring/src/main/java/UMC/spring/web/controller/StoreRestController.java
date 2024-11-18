package UMC.spring.web.controller;

import UMC.spring.api.ApiResponse;
import UMC.spring.converter.StoreConverter;
import UMC.spring.domain.Store;
import UMC.spring.service.storeService.StoreCommandService;
import UMC.spring.web.dto.storeDTO.StoreRequestDTO;
import UMC.spring.web.dto.storeDTO.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {
        Store store = storeCommandService.CreateStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }
}
