package umc.spring.misson5_homework.entity.question;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.misson5_homework.base.BaseEntity;
import umc.spring.misson5_homework.entity.user.User;

import java.util.List;

@Entity
@Table(name = "question")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "question")
    private List<QuestionImage> questionImage;

    @Column(nullable = false, length = 25)
    private String title;

    @Column(nullable = false, length = 25)
    private String content;
}
