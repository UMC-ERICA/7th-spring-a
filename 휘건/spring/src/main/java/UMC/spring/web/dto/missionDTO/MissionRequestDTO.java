package UMC.spring.web.dto.missionDTO;

import lombok.Getter;

import java.time.LocalDate;


public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO{

        String content;

        Integer reward;

        LocalDate expirationDate;

    }

}
