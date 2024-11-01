package umc.spring.misson5_homework.entity.mission;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.base.BaseEntity;
import umc.spring.misson5_homework.entity.user.UserMisson;
import umc.spring.misson5_homework.entity.restaurant.Restaurant;
import umc.spring.misson5_homework.enums.MissonState;

import java.util.List;

@Entity
@Table(name = "misson")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Misson extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "misson")
    private List<UserMisson> userMisson;

    @OneToMany(mappedBy = "misson")
    private List<VerifyMisson> verifyMisson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT '진행중'")
    private MissonState state;

    @Column(nullable = false)
    private int point = 0;



}
