package umc.spring.example.repository.storeRepository;

import umc.spring.example.domain.mapping.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
