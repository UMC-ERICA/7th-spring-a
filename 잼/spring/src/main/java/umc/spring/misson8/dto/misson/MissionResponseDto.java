package umc.spring.misson8.dto.misson;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MissionResponseDto {
    private Long id;
    private String title;
    private String state;
    private String content;
    private String userName;
    private String restaurantName;
}