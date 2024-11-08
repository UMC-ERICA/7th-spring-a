package UMC.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MyPageDTO {

    private Long memberId;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private Integer memberPoint;
}
