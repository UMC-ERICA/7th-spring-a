package umc.spring.repository.memberRepository;

import com.querydsl.core.Tuple;

public interface MemberRepositoryCustom {
    Tuple findMemberById(Long memberId);
}
