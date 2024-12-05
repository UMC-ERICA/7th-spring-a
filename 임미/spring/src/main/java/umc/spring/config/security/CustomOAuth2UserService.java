package umc.spring.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import umc.spring.domain.enumClass.Gender;
import umc.spring.domain.enumClass.Role;
import umc.spring.domain.member.Address;
import umc.spring.domain.member.Member;
import umc.spring.repository.memberRepository.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 클라이언트 이름 (google, naver, kakao 등) 가져오기
        String clientName = userRequest.getClientRegistration().getRegistrationId();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email;
        String nickname;

        if ("kakao".equals(clientName)) {
            // 카카오 로그인 처리
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            nickname = (String) properties.get("nickname");
            email = nickname + "@kakao.com"; // 임시 이메일 생성
        } else if ("naver".equals(clientName)) {
            // 네이버 로그인 처리
            Map<String, Object> response = (Map<String, Object>) attributes.get("response");
            nickname = (String) response.get("nickname");
            email = (String) response.get("email");
        } else if ("google".equals(clientName)) {
            // 구글 로그인 처리
            email = (String) attributes.get("email");
            nickname = (String) attributes.get("name"); // Google에서는 `name` 필드에 닉네임이 포함됨
        } else {
            throw new OAuth2AuthenticationException("Unsupported client: " + clientName);
        }

        // 사용자 정보 저장 또는 업데이트
        Member member = saveOrUpdateUser(email, nickname);

        // 이메일을 Principal로 사용하기 위해 attributes 수정
        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
        modifiedAttributes.put("email", email);

        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                modifiedAttributes,
                "email"  // email을 Principal로 설정
        );
    }


    private Member saveOrUpdateUser(String email, String nickname) {
        Member member = memberRepository.findByEmail(email)
                .orElse(Member.builder()
                        .email(email)
                        .name(nickname)
                        .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
                        .gender(Gender.MALE)
                        .point(0)
                        .status(true)
                        .address(null)// 기본값 설정
                        .role(Role.USER)
                        .build());

        return memberRepository.save(member);
    }
}