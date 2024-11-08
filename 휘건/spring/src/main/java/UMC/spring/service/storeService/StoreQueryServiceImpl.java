package UMC.spring.service.storeService;


import UMC.spring.domain.Store;
import UMC.spring.repository.storeRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;


    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String storeName, BigDecimal storeRate) {
        List<Store> filterdStores = storeRepository.dynamicQueryWithBooleanBuilder(storeName, storeRate);

        filterdStores.forEach(store -> System.out.println("Store: " + store));

        return filterdStores;
    }
}
