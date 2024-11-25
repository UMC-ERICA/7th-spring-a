package umc.spring.example.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.example.base.BaseEntity;
import umc.spring.example.domain.Member;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private String content;

    private int rating;

    @Column(nullable = false)
    @Setter
    private String body; // 본문 내용

    @Setter
    private float score; // 별점


    @Builder
    public Review(Member member,Store store, String content, int rating) {
        this.member = member;
        this.store = store;
        this.content = content;
        this.rating = rating;
    }
}
