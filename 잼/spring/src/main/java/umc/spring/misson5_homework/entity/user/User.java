package umc.spring.misson5_homework.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.base.BaseEntity;
import umc.spring.misson5_homework.entity.food.FavoriteFood;
import umc.spring.misson5_homework.entity.notice.Notice;
import umc.spring.misson5_homework.entity.question.Question;
import umc.spring.misson5_homework.entity.review.Review;
import umc.spring.misson5_homework.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<FavoriteFood> favoriteFoods;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address_id", nullable = false)
    private UserAddress userAddress;

    @OneToMany(mappedBy = "user")
    private List<SocialLogin> socialLogins;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Notice> notices;

    @OneToMany(mappedBy = "user")
    private List<Question> questions;


    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;

    @Column(nullable = false)
    private int point = 0;

    //약관 동의
    private Boolean termsAccepted;

}
