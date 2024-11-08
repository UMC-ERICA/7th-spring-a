package umc.spring.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberNotificationDTO {

    private Long memberId;
    private Integer point;
    private String neighborhood;
    private Long notiCount;
    private Boolean unreadNoti;
    private Long completeMiss;
    private Integer totalMiss;

}
