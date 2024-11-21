package umc.spring.misson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.misson8.entity.restaurant.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}
