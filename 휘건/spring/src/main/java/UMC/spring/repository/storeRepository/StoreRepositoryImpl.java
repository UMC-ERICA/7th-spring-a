package UMC.spring.repository.storeRepository;

import UMC.spring.domain.QStore;
import UMC.spring.domain.Store;
import com.querydsl.core.BooleanBuilder;

import java.math.BigDecimal;
import java.util.List;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String storeName, BigDecimal storeRate) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (storeName != null) {
            predicate.and(store.storeName.eq(storeName));
        }

        if (storeRate != null) {
            predicate.and(store.storeRate.goe(4.0));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }

}
