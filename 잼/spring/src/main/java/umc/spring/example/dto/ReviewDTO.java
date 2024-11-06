package umc.spring.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long userId;
    private Long storeId;
    private String content;
    private Integer rating;

}
