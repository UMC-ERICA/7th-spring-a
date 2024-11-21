package umc.spring.misson8.dto;

import lombok.*;

import java.time.LocalDate;


@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String gender;
    private LocalDate birthday;
    private int point;
    private Boolean termsAccepted;

}
