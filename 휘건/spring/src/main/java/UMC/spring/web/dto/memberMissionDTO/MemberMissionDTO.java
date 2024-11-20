package UMC.spring.web.dto.memberMissionDTO;

import UMC.spring.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberMissionDTO {
    private Long memberMissionId;
    private MissionStatus missionStatus;
    private String content;
    private String reward;
}
