package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.MemberFoodCategory;
import umc.spring.domain.Review;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.enumClass.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Gender gender;

    private LocalDate birthday;

    private Integer point;

    private Boolean status;

    private String email;


    // 매핑

    @OneToOne(mappedBy = "member")
    private Address address;


    @OneToOne(mappedBy = "member")
    private Agree agree;

    @OneToMany(mappedBy = "member")
    private List<Question> questions= new ArrayList<>();

    @OneToOne(mappedBy = "member")
    private Alarm alarm;

    @OneToMany(mappedBy = "member")
    private List<MemberFoodCategory> memberFoodCategories = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviews=new ArrayList<>();
}
