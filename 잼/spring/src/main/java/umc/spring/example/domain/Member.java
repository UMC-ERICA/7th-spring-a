package umc.spring.example.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.example.domain.enums.Gender;
import umc.spring.example.domain.enums.MemberStatus;
import umc.spring.example.domain.enums.Role;
import umc.spring.example.domain.enums.SocialType;
import umc.spring.example.domain.mapping.*;
import umc.spring.misson.base.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@DynamicUpdate
@DynamicInsert
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;




    private LocalDate inactiveDate;

    @Column(length = 15)  // 전화번호 길이 제한 추가
    private String phone;
    
    // 유저의 포인트
    @ColumnDefault("0")
    private Integer point;

    // 필요한 경우 추가할 필드 예시
    private Long completeMiss;


    // 유저의 알림 목록 - 읽지 않은 알림을 조회할 때 사용
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();

    // 유저의 완료된 미션 수 조회용 연관 관계
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    // 유저가 속한 주소 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_address_id")
    private MemberAddress memberAddress;

    // 추가 연관 관계 - 필요한 경우
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    public void encodePassword(String password) {
        this.password = password;
    }

}
