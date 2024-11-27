package umc.spring.misson.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.misson.entity.user.UserMisson;
import umc.spring.misson.enums.MissonStatus;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMissonFindDto {

    private String userName;
    private String title;
    private String subtitle;
    private String content;
    private MissonStatus status;
    private LocalDate deadline;
    private int rating;

    public UserMissonFindDto(UserMisson userMisson) {
        this.userName = userMisson.getUser().getName();  // 사용자 이름
        this.title = userMisson.getTitle();               // 미션 제목
        this.subtitle = userMisson.getSubtitle();         // 미션 부제목
        this.content = userMisson.getContent();           // 미션 내용
        this.status = userMisson.getState();              // 미션 상태
        this.deadline = userMisson.getDeadline();         // 기한
        this.rating = userMisson.getRating();             // 평점
    }


}
