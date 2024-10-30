package umc.spring.misson5_homework.entity.review;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.base.BaseEntity;
import umc.spring.misson5_homework.entity.user.User;
import umc.spring.misson5_homework.entity.restaurant.Restaurant;

import java.util.List;

@Entity
@Table(name = "review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "review")
    private List<ReviewImage> reviewImages;

    @Column
    private int rating;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

}
