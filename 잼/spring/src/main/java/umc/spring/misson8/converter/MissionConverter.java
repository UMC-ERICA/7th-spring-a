package umc.spring.misson8.converter;

import org.springframework.stereotype.Component;
import umc.spring.misson5_ex.domain.mapping.Mission;
import umc.spring.misson8.dto.misson.MissionResponseDto;
import umc.spring.misson8.entity.mission.Misson;
import umc.spring.misson8.entity.user.User;
import umc.spring.misson8.entity.user.UserMisson;
import umc.spring.misson8.enums.MissonStatus;

@Component
public class MissionConverter {

    // UserMission 엔티티 생성 메서드
    public UserMisson convertToEntity(Misson misson, User user) {
        return UserMisson.builder()
                .misson(misson)
                .user(user)
                .state(MissonStatus.IN_PROGRESS) // default
                .build();
    }

    // DTO 변환 메서드
    public MissionResponseDto convertToDto(UserMisson userMission) {
        return new MissionResponseDto(
                userMission.getId(),
                userMission.getMisson().getTitle(),
                userMission.getState().getDescription(), // Enum에서 description 추출
                userMission.getMisson().getContent(),
                userMission.getUser().getName(),
                userMission.getMisson().getRestaurant().getName()
        );
    }
}
