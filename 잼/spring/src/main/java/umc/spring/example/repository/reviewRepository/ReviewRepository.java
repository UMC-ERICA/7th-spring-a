package umc.spring.example.repository.reviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.example.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
