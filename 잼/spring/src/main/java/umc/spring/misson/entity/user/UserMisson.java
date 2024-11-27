package umc.spring.misson.entity.user;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.misson.base.BaseEntity;
import umc.spring.misson.entity.mission.Misson;
import umc.spring.misson.enums.MissonStatus;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user_mission")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserMisson extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "misson_id", nullable = false)
    private Misson misson;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(length = 10)
    private String subtitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private MissonStatus state;

    @Column(nullable = false)
    private int rating;

}
