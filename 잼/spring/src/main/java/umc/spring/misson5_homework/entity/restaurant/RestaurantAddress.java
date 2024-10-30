package umc.spring.misson5_homework.entity.restaurant;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.base.BaseEntity;

@Entity
@Table(name = "restaurant_address")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantAddress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String distinct;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String detail;


}
