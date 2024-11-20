package umc.spring.misson8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.misson8.converter.MissionConverter;
import umc.spring.misson8.dto.misson.MissionRequestDto;
import umc.spring.misson8.dto.misson.MissionResponseDto;
import umc.spring.misson8.entity.user.User;
import umc.spring.misson8.entity.user.UserMisson;
import umc.spring.misson8.entity.mission.Misson;

import umc.spring.misson8.exception.MissonNotFoundException;
import umc.spring.misson8.exception.UserNotFoundException;
import umc.spring.misson8.repository.MissionRepository;
import umc.spring.misson8.repository.UserMissionRepository;
import umc.spring.misson8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    private final MissionConverter missionConverter;

    @Transactional
    public MissionResponseDto plusMission(Long userId, MissionRequestDto dto) {

        // 사용자 확인
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("회원이 존재하지 않습니다."));

        // 미션 확인
        Misson mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new MissonNotFoundException("미션이 존재하지 않습니다."));

        // 이미 도전 중인지 확인
        boolean isAlreadyChallenged = userMissionRepository.existsByUserAndMisson(user, mission);
        if (isAlreadyChallenged) {
            throw new IllegalArgumentException("이미 도전 중인 미션입니다.");
        }

        // UserMission 생성 및 저장
        UserMisson userMission = missionConverter.convertToEntity(mission, user);
        UserMisson savedUserMission = userMissionRepository.save(userMission);

        // DTO로 변환 후 반환
        return missionConverter.convertToDto(savedUserMission);
    }
}
