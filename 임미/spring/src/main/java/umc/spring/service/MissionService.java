package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.web.dto.MissionDTO;

@Service
public interface MissionService {
    MissionDTO.MissionResponseDTO saveMission(MissionDTO.MissionRequestDTO request,
                                              Long storeId);
}
