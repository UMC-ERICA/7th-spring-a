package umc.spring.example.repository.missonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.example.domain.mapping.Mission;

public interface MissonRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
