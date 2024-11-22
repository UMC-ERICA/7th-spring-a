package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.domain.member.Member;
import umc.spring.web.dto.MemberRequestDTO;

@Service
public interface MemberService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
