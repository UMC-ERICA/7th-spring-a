package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.context.properties.bind.DefaultValue;
import umc.spring.domain.MemberFoodCategory;
import umc.spring.domain.Review;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enumClass.Role;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.enumClass.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DynamicUpdate
@DynamicInsert
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

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;

    @ColumnDefault("0")
    private Integer point;

    // 회원 삭제 시, 보류 상태로 유지
    private Boolean status=Boolean.TRUE;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String password;

    // 매핑

    @OneToOne(mappedBy = "member")
    private Address address;


    @OneToOne(mappedBy = "member")
    private Agree agree;

    @OneToMany(mappedBy = "member")
    private List<Question> questions= new ArrayList<>();

    @OneToOne(mappedBy = "member")
    private Alarm alarm;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberFoodCategory> memberFoodCategories = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Review> reviews=new ArrayList<>();
}
