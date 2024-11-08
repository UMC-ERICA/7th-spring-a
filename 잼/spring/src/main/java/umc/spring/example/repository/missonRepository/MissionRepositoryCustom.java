package umc.spring.example.repository.missonRepository;

import umc.spring.example.dto.MissonDTO;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MissionRepositoryCustom {
    List<MissonDTO> getOngoingMissons(Pageable pageable);
    List<MissonDTO> getCompletedMissions(Pageable pageable);
}
