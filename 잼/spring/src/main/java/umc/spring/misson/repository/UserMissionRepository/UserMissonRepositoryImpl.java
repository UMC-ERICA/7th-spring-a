package umc.spring.misson.repository.UserMissionRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.spring.misson.entity.user.QUserMisson;
import umc.spring.misson.entity.user.UserMisson;
import umc.spring.misson.enums.MissonStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserMissonRepositoryImpl implements UserMissonRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<UserMisson> findByTitleAndStatus(MissonStatus status, Pageable pageable) {
        QUserMisson userMisson = QUserMisson.userMisson;

        //진행 중인 미션들을 페이징 처리해서 조회
        JPAQuery<UserMisson> query = queryFactory
                .selectFrom(userMisson)
                .where(userMisson.state.eq(MissonStatus.IN_PROGRESS))
                .offset(pageable.getOffset())
                .limit(pageable.getOffset())
                .orderBy(userMisson.deadline.asc());//기한순 정렬

        //페이징된 결과를 반환
        List<UserMisson> results = query.fetch();

        return new PageImpl<>(results, pageable, results.size());

    }

    @Override
    public void completeMisson(Long userMissonId) {
        QUserMisson userMisson = QUserMisson.userMisson;

        //진행 중인 미션 -> 완료 상태로 변경
        queryFactory.update(userMisson)
                .set(userMisson.state, MissonStatus.COMPLETE)
                .where(userMisson.id.eq(userMissonId)
                        .and(userMisson.state.eq(MissonStatus.IN_PROGRESS)))
                .execute();
    }
}
