package UMC.spring.config.security;

import UMC.spring.domain.Member;
import UMC.spring.domain.enums.Role;
import UMC.spring.domain.enums.MemberGender;
import UMC.spring.repository.memberRepository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("CustomOAuth2UserService - loadUser 호출됨");
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("CustomOAuth2UserService - OAuth2User: {}", oAuth2User);


        Map<String, Object> attributes = oAuth2User.getAttributes();
        log.info("카카오 사용자 정보 attributes: {}", attributes);
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");

        String nickname = (String) properties.get("nickname");
        log.info("카카오 사용자 닉네임: {}", nickname);
        String email = nickname + "@kakao.com"; // 임시 이메일 생성
        log.info("생성된 임시 이메일: {}", email);


        // 사용자 정보 저장 또는 업데이트
        Member member = saveOrUpdateUser(email, nickname);

        // 이메일을 Principal로 사용하기 위해 attributes 수정
        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
        modifiedAttributes.put("email", email);

        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                modifiedAttributes,
                "email"  // email Principal로 설정
        );
    }

    private Member saveOrUpdateUser(String email, String nickname) {
        Member member = memberRepository.findByEmail(email)
                .orElse(Member.builder()
                        .email(email)
                        .memberName(nickname)
                        .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
                        .gender(MemberGender.MALE)  // 기본값 설정
                        .memberAddress("소셜로그인")  // 기본값 설정
                        .birthdate(LocalDate.of(2001,1,11))
                        .phone("소셜로그인")
                        .role(Role.USER)
                        .build());

        return memberRepository.save(member);
    }
}