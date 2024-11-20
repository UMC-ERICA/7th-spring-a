package umc.spring.misson8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.misson8.converter.UserConverter;
import umc.spring.misson8.dto.UserDto;
import umc.spring.misson8.entity.user.User;
import umc.spring.misson8.exception.UserNotFoundException;
import umc.spring.misson8.repository.UserRepository;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    private UserDto findByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다."));
        return userConverter.convertToUserDto(user);
    }
}
