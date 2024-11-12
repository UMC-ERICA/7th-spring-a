package umc.spring.example.repository.missonRepository;

import org.springframework.data.domain.Page;
import umc.spring.example.dto.MissonDTO;

import org.springframework.data.domain.Pageable;

public interface MissionRepositoryCustom {
    Page<MissonDTO> getOngoingMissons(Pageable pageable);
    Page<MissonDTO> getCompletedMissions(Pageable pageable);
}
