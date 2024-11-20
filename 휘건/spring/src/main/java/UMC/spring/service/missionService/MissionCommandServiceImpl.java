package UMC.spring.service.missionService;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.StoreHandler;
import UMC.spring.converter.MissionConverter;
import UMC.spring.domain.Mission;
import UMC.spring.domain.Store;
import UMC.spring.repository.missionRepository.MissionRepository;
import UMC.spring.repository.storeRepository.StoreRepository;
import UMC.spring.web.dto.missionDTO.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;


    @Override
    public Mission CreateMission(MissionRequestDTO.CreateMissionDTO request, Long storeId) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);


        return missionRepository.save(mission);
    }
}
