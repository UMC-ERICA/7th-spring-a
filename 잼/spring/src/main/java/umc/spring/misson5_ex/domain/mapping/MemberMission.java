package umc.spring.misson5_ex.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc.spring.misson5_ex.domain.Member;
import umc.spring.misson5_ex.domain.common.BaseEntity;
import umc.spring.misson5_ex.domain.enums.MissonStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissonStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "misson_id")
    private Mission mission;
}
