package UMC.spring.domain.mapping;

import UMC.spring.domain.Member;
import UMC.spring.domain.Mission;
import UMC.spring.domain.baseEntity.BaseEntity;

import UMC.spring.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    // Member MTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // Mission MTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @PrePersist
    public void prePersist() {
        if (this.missionStatus == null) {
            this.missionStatus = MissionStatus.IN_PROGRESS;
        }
    }

    public void setMissionStatus(MissionStatus missionStatus) {
        this.missionStatus = missionStatus;
    }
}
