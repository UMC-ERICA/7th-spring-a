package UMC.spring.service.storeService;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import UMC.spring.domain.Store;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String storeName, BigDecimal storeRate);
}