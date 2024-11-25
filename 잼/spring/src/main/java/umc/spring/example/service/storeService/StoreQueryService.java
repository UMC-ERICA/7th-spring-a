package umc.spring.example.service.storeService;

import org.springframework.data.domain.Page;
import umc.spring.example.domain.mapping.Review;
import umc.spring.example.domain.mapping.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long storeId, Integer page);
}
