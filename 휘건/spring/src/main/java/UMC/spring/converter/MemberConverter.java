package UMC.spring.converter;

import UMC.spring.domain.Member;
import UMC.spring.domain.enums.MemberGender;
import UMC.spring.web.dto.memberDTO.MemberRequestDTO;
import UMC.spring.web.dto.memberDTO.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {

        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {
        MemberGender memberGender;

        try {
            memberGender = MemberGender.valueOf(request.getGender().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 성별 입력입니다: " + request.getGender());
        }

        return Member.builder()
                .memberName(request.getMemberName())
                .gender(memberGender)
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .phone(request.getPhone())
                .birthdate(request.getBirthdate())
                .memberAddress(request.getMemberAddress())
                .memberPreferList(new ArrayList<>())
                .build();
    }

}


