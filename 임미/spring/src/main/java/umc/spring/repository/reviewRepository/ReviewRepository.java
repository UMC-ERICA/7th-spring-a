package umc.spring.repository.reviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Review;
import umc.spring.domain.member.Member;
import umc.spring.domain.store.Store;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>,ReviewRepositoryCustom {

    Page<Review> findByMemberAndStore(Member member, Store store, Pageable pageable);
}
