package umc.spring.repository.reviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Review;
import umc.spring.domain.member.Member;
import umc.spring.domain.member.QMember;
import umc.spring.repository.memberRepository.MemberRepository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    private final QMember member = QMember.member;

    public void saveReview(String memberName, String storeName, String content, int score) {

        Long memberId = queryFactory
                .select(member.id)
                .from(member)
                .where(member.name.eq(memberName))
                .fetchOne();

        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(NoSuchElementException::new);


        if (memberId != null) {

            Review newReview = Review.builder()
                            .content(content)
                                    .score(score)
                                            .member(findMember)
                                                    .build();

            reviewRepository.save(newReview);
        } else {
            throw new IllegalArgumentException("해당 멤버나 가게를 찾을 수 없습니다.");
        }
    }
}
