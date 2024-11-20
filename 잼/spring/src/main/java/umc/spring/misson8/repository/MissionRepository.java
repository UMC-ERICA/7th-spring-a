package umc.spring.misson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.misson8.entity.mission.Misson;

public interface MissionRepository extends JpaRepository<Misson, Long> {
}
