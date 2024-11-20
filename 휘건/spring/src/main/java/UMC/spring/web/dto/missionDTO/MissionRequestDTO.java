package UMC.spring.web.dto.missionDTO;

import lombok.Getter;


public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO{

        String content;

        Integer reward;

    }

}
