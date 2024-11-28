package UMC.spring.repository.missionRepository;

import UMC.spring.domain.Mission;
import UMC.spring.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    boolean existsByIdAndStoreId(Long id, Long storeId);

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
