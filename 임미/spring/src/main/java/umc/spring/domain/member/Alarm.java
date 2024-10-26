package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    // 알람 읽음 상태
    private Boolean status;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Member member;
}
