package UMC.spring.repository.memberRepository;

import UMC.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
}
