package umc.spring.misson.repository.reviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.misson.entity.review.QReview;
import umc.spring.misson.entity.review.Review;

import java.util.List;

import static umc.spring.misson.entity.review.QReview.review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> findByTitle(String title) {
        QReview review = QReview.review;


        return queryFactory
                .selectFrom(review)
                .where(review.comment.contains(title))  // 리뷰 내용에 특정 제목이 포함된 리뷰를 찾음
                .fetch();
    }

    @Override
    public List<Review> findAllReviews() {
        return queryFactory
                .selectFrom(review)
                .fetch();  // 모든 리뷰를 조회    }
    }
}
