package UMC.spring.domain;

import UMC.spring.domain.baseEntity.BaseEntity;

import UMC.spring.domain.enums.MemberGender;
import UMC.spring.domain.enums.MemberStatus;
import UMC.spring.domain.enums.SocialLoginType;
import UMC.spring.domain.mapping.MemberAgreement;
import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String memberName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberGender gender;

    private LocalDate birthdate;

    @Column(nullable = false, length = 100)
    private String memberAddress;

    @Column(columnDefinition = "integer default 0")
    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(8) default 'ACTIVE'")
    private MemberStatus memberStatus;

    private LocalDateTime memberInActivateTime;

    @Enumerated(EnumType.STRING)
    private SocialLoginType socialLoginType;

    @Column(nullable = false, length = 60)
    private String email;



    // Review OTM
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    // MemberMission OTM
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    // MemberPrefer OTM
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    // Agreement OTM
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgreement> memberAgreementList = new ArrayList<>();

    // Inquiry OTM
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

    // Alarm OTM
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarmList = new ArrayList<>();

    // Region MTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;


}
