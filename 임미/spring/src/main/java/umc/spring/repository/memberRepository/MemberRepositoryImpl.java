package umc.spring.repository.memberRepository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.member.QAddress;
import umc.spring.domain.member.QMember;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMember member = QMember.member;
    private final QAddress address = QAddress.address;

    @Override
    public Tuple findMemberById(Long memberId) {
        return queryFactory
                .select(
                        member.id,
                        member.name.as("nickname"),
                        member.email,
                        member.point.as("user_point"),
                        address.city.as("user_region")
                )
                .from(member)
                .join(member.address, address)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}