package umc.spring.misson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.misson8.entity.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
