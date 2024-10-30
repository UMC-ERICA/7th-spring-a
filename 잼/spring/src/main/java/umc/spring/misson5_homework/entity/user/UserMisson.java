package umc.spring.misson5_homework.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.entity.mission.Misson;
import umc.spring.misson5_homework.enums.MissonState;

import java.util.Date;

@Entity
@Table(name = "user_mission")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMisson {

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
    private Date deadline;

    @Enumerated(EnumType.STRING)
    private MissonState state;



}
