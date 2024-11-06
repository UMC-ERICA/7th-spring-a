package umc.spring.example.repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.example.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
