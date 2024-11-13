package umc.spring.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDTO {

    private String username;
    private String email;
    private String phone;
    private Integer points;

}