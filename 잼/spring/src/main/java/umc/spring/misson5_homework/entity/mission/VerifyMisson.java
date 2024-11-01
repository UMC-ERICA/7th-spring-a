package umc.spring.misson5_homework.entity.mission;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.enums.VerificationStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "verify_misson")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VerifyMisson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Misson misson;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String variationCode;

    @Column(columnDefinition = "TEXT")
    private String belowText;

    private LocalDateTime verifiedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('success', 'fail') DEFAULT 'success'")
    private VerificationStatus success; // VerificationStatus는 Enum으로 정의

}
