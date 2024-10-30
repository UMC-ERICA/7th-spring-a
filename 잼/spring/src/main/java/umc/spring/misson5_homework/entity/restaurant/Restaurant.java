package umc.spring.misson5_homework.entity.restaurant;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.entity.mission.Misson;
import umc.spring.misson5_homework.enums.RestaurantStatus;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_category_id",nullable = false)
    private RestaurantCategory category; // 카테고리와의 관계

    @OneToMany(mappedBy = "restaurant")
    private List<Misson> missonList;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantAddress> restaurantAddresses;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantImage> restaurantImages;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal averageRating = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RestaurantStatus restaurantStatus;


}
