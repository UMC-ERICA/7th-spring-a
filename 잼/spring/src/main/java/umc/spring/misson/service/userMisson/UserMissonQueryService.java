package umc.spring.misson.service.userMisson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.misson.annotation.custom.CustomPage;
import umc.spring.misson.dto.user.UserMissonFindDto;
import umc.spring.misson.entity.user.UserMisson;
import umc.spring.misson.enums.MissonStatus;
import umc.spring.misson.repository.UserMissionRepository.UserMissionRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserMissonQueryService {

    private final UserMissionRepository userMissionRepository;


    public Page<UserMissonFindDto> getInProgressMissions(@CustomPage Integer page) {
        page = (page > 0) ? page - 1 : 0; // page가 1일 경우 0으로 변경
        Pageable pageable = PageRequest.of(page, 10, Sort.by("deadline").ascending());  // 기한순으로 정렬

        Page<UserMisson> userMissions = userMissionRepository.findByTitleAndStatus(MissonStatus.IN_PROGRESS, pageable);

        // Stream을 사용하여 UserMisson을 UserMissonFindDTO로 변환
        return userMissions.map(UserMissonFindDto::new);
    }

    public void completeMisson(Long userMissonId) {
        userMissionRepository.completeMisson(userMissonId);  // 미션 완료 상태로 변경
    }

}
