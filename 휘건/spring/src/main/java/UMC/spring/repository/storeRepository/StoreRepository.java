package UMC.spring.repository.storeRepository;

import UMC.spring.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom  {

    public Optional<Store> findById(Long storeId);
}
