package umc.spring.example.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import umc.spring.example.domain.Member;
import umc.spring.example.domain.enums.Gender;
import umc.spring.example.domain.enums.Role;
import umc.spring.example.repository.memberRepository.MemberRepository;

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

        //카카오에서 제공하는 사용자 정보를 OAuth2User 객체로 받아옴
        //이 객체의 attributes에는 사용자의 닉네임 등 기본 정보가 포함 되어 있음.
        OAuth2User oAuth2User = super.loadUser(userRequest);


        //카카오 API에서 제공하는 사용자 정보 중 nickname을 추출
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        String nickname = (String) properties.get("nickname");

        //닉네임을 이용해 임시 이메일 주소 생성
        String email = nickname + "@kakao.com"; // 임시 이메일 생성

        // 사용자 정보 저장 또는 업데이트
        Member member = saveOrUpdateUser(email, nickname);

        // 이메일을 Principal로 사용하기 위해 attributes 수정
        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
        modifiedAttributes.put("email", email);

        //사용자의 권한, 속성, 그리고 주요 식별자(email)를 설정 후,
        //Spring security가 인증된 사용자를 올바르게 식별하고 처리할 수 있도록 함
        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                modifiedAttributes,
                "email"  // email Principal로 설정
        );
    }

    /**
     * 사용자 정보를 데이터베이스에 저장하거나 업데이트
     * 임시 이메일을 기준으로 기존 사용자를 찾거나 새 사용자를 생성
     * 카카오에서 제공하지 않는 정보(성별, 주소 등)는 기본값으로 설정
     */
    private Member saveOrUpdateUser(String email, String nickname) {
        Member member = memberRepository.findByEmail(email)
                .orElse(Member.builder()
                        .email(email)
                        .name(nickname)
                        .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
                        .gender(Gender.NONE)  // 기본값 설정
                        .address("소셜로그인")  // 기본값 설정
                        .specAddress("소셜로그인")  // 기본값 설정
                        .role(Role.USER)
                        .build());

        return memberRepository.save(member);
    }

}
