package umc.spring.misson.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.misson.entity.mission.Misson;
import umc.spring.misson.entity.user.User;
import umc.spring.misson.entity.user.UserMisson;

public interface UserMissionRepository extends JpaRepository<UserMisson,Long>, UserMissonRepositoryCustom {
    boolean existsByUserAndMisson(User user, Misson misson);
}
