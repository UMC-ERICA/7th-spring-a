package umc.spring.example.repository.memberRepository;

import umc.spring.example.dto.MemberInfoDTO;
import umc.spring.example.dto.MemberNotificationDTO;

public interface MemberRepositoryCustom {
    MemberInfoDTO getMemberInfo(Long memberId);

    MemberNotificationDTO getMemberNotificationInfo(Long userId);

}
