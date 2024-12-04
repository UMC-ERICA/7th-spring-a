package UMC.spring.service.memberService;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.PreferHandler;
import UMC.spring.converter.MemberConverter;
import UMC.spring.domain.Member;
import UMC.spring.domain.Prefer;
import UMC.spring.repository.memberRepository.MemberRepository;
import UMC.spring.repository.preferRepository.PreferRepository;
import UMC.spring.web.dto.memberDTO.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final PreferRepository preferRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDTO request) {
        System.out.println("회원가입 요청 데이터: " + request);

        // Member 변환
        Member newMember = MemberConverter.toMember(request);
        System.out.println("변환된 Member 객체: " + newMember);

        // 비밀번호 암호화
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        System.out.println("암호화된 비밀번호: " + newMember.getPassword());

        // 선호 카테고리 처리
        List<Long> preferCategories = request.getPreferCategory();
        if (preferCategories == null || preferCategories.isEmpty()) {
            System.out.println("선호 카테고리 값이 비어 있습니다.");
            preferCategories = List.of();
        }

        List<Prefer> foodCategoryList = preferCategories.stream()
                .map(category -> preferRepository.findById(category)
                        .orElseThrow(() -> new PreferHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .toList();
        System.out.println("처리된 선호 카테고리: " + foodCategoryList);

        // DB 저장
        Member savedMember = memberRepository.save(newMember);
        System.out.println("DB에 저장된 Member: " + savedMember);

        return savedMember;
    }
}
