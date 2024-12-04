package UMC.spring.repository.memberRepository;

import UMC.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {

    Optional<Member> findById(Long memberId);

    Optional<Member> findByEmail(String email);
}
