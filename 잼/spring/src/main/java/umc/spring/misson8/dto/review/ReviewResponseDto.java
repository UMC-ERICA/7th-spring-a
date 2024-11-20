package umc.spring.misson8.dto.review;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private String comment;
    private int rating;
    private String restaurantName;
    private String userName;
    private List<String> reviewImages;

}
