package umc.spring.example.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.example.domain.Member;
import umc.spring.example.domain.enums.NotificationStatus;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
