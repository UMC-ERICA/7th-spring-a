package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.store.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.MissionDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionDTO.MissionResponseDTO saveMission(MissionDTO.MissionRequestDTO request,
                                                     Long storeId){

        Store storeById = storeRepository.findById(storeId)
                .orElseThrow(()->new RuntimeException("상점을 찾을 수 없습니다"));

        Mission newMission = Mission.builder()
                .content(request.getContent())
                .point(request.getPoint())
                .status(Boolean.FALSE)
                .deadline(request.getDeadLine())
                .store(storeById)
                .build();

        missionRepository.save(newMission);

        return MissionDTO.MissionResponseDTO.builder()
                .id(newMission.getId())
                .build();

    }

}
