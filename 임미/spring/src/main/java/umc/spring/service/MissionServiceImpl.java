package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.store.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.MissionDTO;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionDTO.MissionResponseDTO saveMission(MissionDTO.MissionRequestDTO request){

        Store storeById = storeRepository.findById(request.getStoreId())
                .orElseThrow(()->new RuntimeException("상점을 찾을 수 없습니다"));

        Mission newMission = MissionConverter.toMission(request,storeById);

        missionRepository.save(newMission);

        return MissionDTO.MissionResponseDTO.builder()
                .id(newMission.getId())
                .build();

    }


}
