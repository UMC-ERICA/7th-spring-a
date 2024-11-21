package umc.spring.misson8.converter;

import org.springframework.stereotype.Component;
import umc.spring.misson8.dto.UserDto;
import umc.spring.misson8.entity.user.User;

@Component
public class UserConverter {
    // User 엔티티를 UserDto로 변환

    public UserDto convertToUserDto(User user) {
        if (user == null) {
            return null; // null 체크
        }
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.getGender() != null ? user.getGender().name() : null) // Enum을 String으로 변환
                .birthday(user.getBirthday())
                .point(user.getPoint())
                .termsAccepted(user.getTermsAccepted())
                .build();
    }
}
