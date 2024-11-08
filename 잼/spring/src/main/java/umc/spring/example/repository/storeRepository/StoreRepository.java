package umc.spring.example.repository.storeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.example.domain.mapping.Store;

public interface StoreRepository extends JpaRepository<Store,Long>, StoreRepositoryCustom {


}
