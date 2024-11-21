package UMC.spring.repository.regionRepository;

import UMC.spring.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {

    Optional<Region> findByCityAndDistrictAndNeighborhood(String city, String district, String neighborhood);
}
