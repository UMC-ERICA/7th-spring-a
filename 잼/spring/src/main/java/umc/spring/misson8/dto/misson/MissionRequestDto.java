package umc.spring.misson8.dto.misson;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import umc.spring.misson8.annotation.CustomValidation;
import umc.spring.misson8.enums.MissonStatus;

@Data
public class MissionRequestDto {

    @NotBlank(message = "미션 제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "미션 상태를 입력해주세요.")
    private MissonStatus state;

    @NotBlank(message = "미션 내용을 입력해주세요.")
    private String content;

    @CustomValidation(message = "유효하지 않은 미션 ID입니다.")
    private Long missionId;

}
