package umc.spring.misson.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.misson.entity.user.UserMisson;
import umc.spring.misson.enums.MissonStatus;


public interface UserMissonRepositoryCustom {
    Page<UserMisson> findByTitleAndStatus(MissonStatus status, Pageable pageable);
    void completeMisson(Long userMissonId);
    }
