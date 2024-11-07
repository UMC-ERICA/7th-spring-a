package UMC.spring.repository.memberRepository;

import UMC.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {

    public Optional<Member> findById(Long memberId);
}
