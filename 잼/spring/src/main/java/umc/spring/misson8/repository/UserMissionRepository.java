package umc.spring.misson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.misson8.entity.mission.Misson;
import umc.spring.misson8.entity.user.User;
import umc.spring.misson8.entity.user.UserMisson;

public interface UserMissionRepository extends JpaRepository<UserMisson,Long> {
    boolean existsByUserAndMisson(User user, Misson misson);
}
