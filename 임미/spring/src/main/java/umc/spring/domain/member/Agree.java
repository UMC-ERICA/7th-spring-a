package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Agree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 연령 동의
    private Boolean ageAgree;

    // 서비스 이용 약관 동의
    private Boolean serviceAgree;

    // 개인정보 처리 방침
    private Boolean detailsAgree;

    // 위치정보 제공
    private Boolean locationAgree;

    // 마케팅 수신 동의
    private Boolean marketingAlarmAgree;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Member member;
}
