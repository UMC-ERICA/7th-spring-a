package umc.spring.misson5_ex.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.misson5_ex.domain.enums.Gender;
import umc.spring.misson5_ex.domain.enums.MemberStatus;
import umc.spring.misson5_ex.domain.enums.SocialType;
import umc.spring.misson5_ex.domain.mapping.MemberAgree;
import umc.spring.misson5_ex.domain.mapping.MemberMission;
import umc.spring.misson5_ex.domain.mapping.MemberPrefer;
import umc.spring.misson5_ex.domain.mapping.Review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMission = new ArrayList<>();


}
