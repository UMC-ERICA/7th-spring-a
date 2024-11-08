package umc.spring.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissonDTO {

    private Integer point;
    private String state;
    private String content;

}
