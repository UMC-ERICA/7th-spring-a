package umc.spring.domain.mission;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.store.Store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // 미션 성공 시, 부여되는 포인트
    private Integer point;

    // 미션 성공 여부
    private Boolean status;

    // 미션 마감기한
    private LocalDate deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions=new ArrayList<>();
}
