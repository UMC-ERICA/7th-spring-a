package umc.spring.example.repository.memberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import umc.spring.example.domain.QMember;
import umc.spring.example.domain.mapping.QMemberAddress;
import umc.spring.example.domain.mapping.QMemberMission;
import umc.spring.example.domain.mapping.QNotification;
import umc.spring.example.dto.MemberInfoDTO;
import umc.spring.example.dto.MemberNotificationDTO;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.Expressions;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public MemberInfoDTO getMemberInfo(Long memberId) {
        QMember member = QMember.member;

        return queryFactory.select(Projections.fields(MemberInfoDTO.class,
                        member.name,
                        member.email,
                        member.phone,
                        member.point))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }

    @Override
    public MemberNotificationDTO getMemberNotificationInfo(Long userId) {
        QMember member = QMember.member;
        QMemberAddress memberAddress = QMemberAddress.memberAddress;
        QNotification notification = QNotification.notification;
        QMemberMission memberMission = QMemberMission.memberMission;

        // 읽지 않은 알림의 수를 카운트
        NumberExpression<Long> notiCount = notification.id.count();

        // 완료된 미션의 수를 카운트
        NumberExpression<Long> completeMiss = memberMission.mission.id.count();

        return queryFactory.select(Projections.fields(MemberNotificationDTO.class,
                        member.id.as("memberId"),
                        member.point.as("point"),
                        memberAddress.neighborhood,
                        notiCount.as("notiCount"),
                        notiCount.gt(0L).as("unreadNoti"),
                        completeMiss.as("completeMiss"),
                        Expressions.constant(10) // `as("totalMiss")`를 생략
                ))
                .from(member)
                .join(member.memberAddress, memberAddress)
                .leftJoin(notification).on(notification.member.eq(member))
                .leftJoin(memberMission).on(memberMission.member.eq(member)
                        .and(memberMission.state.eq("성공")))
                .where(member.id.eq(member.id))
                .groupBy(member.id, member.point, memberAddress.neighborhood)
                .fetchOne();
    }

}
