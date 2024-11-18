package UMC.spring.service.memberService;

import UMC.spring.domain.Member;
import UMC.spring.web.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDTO request);

}
