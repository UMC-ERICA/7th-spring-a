package UMC.spring.repository.missionRepository;

import UMC.spring.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    boolean existsByIdAndStoreId(Long id, Long store_id);
}
