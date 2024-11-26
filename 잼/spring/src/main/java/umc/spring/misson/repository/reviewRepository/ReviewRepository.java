package umc.spring.misson.repository.reviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.misson.entity.review.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>, ReviewRepositoryCustom {

}
