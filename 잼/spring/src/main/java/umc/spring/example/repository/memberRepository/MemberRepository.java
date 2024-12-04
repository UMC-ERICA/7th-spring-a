package umc.spring.example.repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.example.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

}
