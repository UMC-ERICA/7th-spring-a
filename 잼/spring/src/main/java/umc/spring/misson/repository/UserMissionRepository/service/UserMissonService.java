package umc.spring.misson.repository.UserMissionRepository.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.misson.entity.user.UserMisson;
import umc.spring.misson.repository.UserMissionRepository.UserMissionRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserMissonService {

    private final UserMissionRepository userMissionRepository;

    /**
     * userMisson 저장
     */
    public UserMisson savedUserMisson(UserMisson userMisson) {
        return userMissionRepository.save(userMisson);
    }

    /**
     * UserMisson 목록 조회
     */
    @Transactional(readOnly = true)
    public List<UserMisson> getUserMisson() {
        return userMissionRepository.findAll();
    }
}
