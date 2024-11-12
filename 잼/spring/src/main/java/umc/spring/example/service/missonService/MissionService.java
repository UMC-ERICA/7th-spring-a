package umc.spring.example.service.missonService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.example.dto.MissonDTO;
import umc.spring.example.repository.missonRepository.MissonRepository;

@Service
public class MissionService {

    private final MissonRepository missionRepository;

    public MissionService(MissonRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public Page<MissonDTO> getOngoingMissions(Pageable pageable) {
        return missionRepository.getOngoingMissons(pageable);
    }

    public Page<MissonDTO> getCompletedMissions(Pageable pageable) {
        return missionRepository.getCompletedMissions(pageable);
    }
}