package UMC.spring.repository.storeRepository;

import UMC.spring.domain.Store;

import java.math.BigDecimal;
import java.util.List;

public interface StoreRepositoryCustom {

    List<Store> dynamicQueryWithBooleanBuilder(String storeName, BigDecimal storeRate);
}
