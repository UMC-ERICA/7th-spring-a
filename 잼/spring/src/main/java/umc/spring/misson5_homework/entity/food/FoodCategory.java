package umc.spring.misson5_homework.entity.food;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.entity.restaurant.RestaurantCategory;

import java.util.List;

@Entity
@Table(name = "food_category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "foodCategory")
    private List<FavoriteFood> favoriteFoods;

    @OneToMany(mappedBy = "foodCategory")
    private List<RestaurantCategory> restaurantCategories;

    @Column(nullable = false, unique = true)
    private String name;
}
