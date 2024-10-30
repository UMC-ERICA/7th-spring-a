package umc.spring.misson5_ex.domain.mapping;

import jakarta.persistence.*;
import umc.spring.misson5_ex.domain.Member;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
