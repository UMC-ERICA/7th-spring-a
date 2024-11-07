package UMC.spring.repository.memberRepository;

import UMC.spring.web.dto.MyPageDTO;

public interface MemberRepositoryCustom {

    MyPageDTO findMemberById(Long memberId);

}
