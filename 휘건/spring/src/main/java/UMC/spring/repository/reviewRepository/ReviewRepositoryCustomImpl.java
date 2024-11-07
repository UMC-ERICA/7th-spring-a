package UMC.spring.repository.reviewRepository;

import UMC.spring.domain.Review;
import UMC.spring.web.dto.ReviewCreateDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom{
}
