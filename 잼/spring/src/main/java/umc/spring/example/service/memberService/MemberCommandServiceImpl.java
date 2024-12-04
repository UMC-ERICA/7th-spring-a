package umc.spring.example.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.example.apiPayload.code.status.ErrorStatus;
import umc.spring.example.converter.MemberConverter;
import umc.spring.example.converter.MemberPreferConverter;
import umc.spring.example.domain.Member;
import umc.spring.example.domain.mapping.FoodCategory;
import umc.spring.example.domain.mapping.MemberPrefer;
import umc.spring.example.dto.MemberRequestDTO;
import umc.spring.example.handler.FoodCategoryHandler;
import umc.spring.example.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.example.repository.memberRepository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }


}