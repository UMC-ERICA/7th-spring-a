package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.web.dto.StoreDTO;

@Service
public interface StoreService {
    StoreDTO.StoreSaveResponseDTO save(StoreDTO.StoreSaveRequestDTO request);
}
