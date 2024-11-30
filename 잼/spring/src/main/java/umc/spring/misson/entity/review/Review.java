package umc.spring.misson.entity.review;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.misson.base.BaseEntity;
import umc.spring.misson.entity.user.User;
import umc.spring.misson.entity.restaurant.Restaurant;

import java.util.List;

@Entity
@Table(name = "review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
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

