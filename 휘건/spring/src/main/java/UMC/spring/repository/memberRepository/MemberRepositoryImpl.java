package UMC.spring.repository.memberRepository;

import UMC.spring.domain.QMember;
import UMC.spring.web.dto.MyPageDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public MyPageDTO findMemberById(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(member.id.eq(memberId));

        return jpaQueryFactory
                .select(Projections.fields(MyPageDTO.class,
                        member.memberName,
                        member.email,
                        member.phone,
                        member.point))
                .from(member)
                .where(predicate)
                .fetchOne();

    }
}
