package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Boolean status;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Member member;
}
