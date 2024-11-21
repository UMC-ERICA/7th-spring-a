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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final PreferRepository preferRepository;


    @Override
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);

        List<Prefer> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return preferRepository.findById(category).orElseThrow(
                            () -> new PreferHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).toList();


        return memberRepository.save(newMember);
    }
}
