package UMC.spring.web.dto.memberMissionDTO;

import lombok.Getter;

import java.time.LocalDate;

public class MemberMissionRequestDTO {

    @Getter
    public static class CreateMemberMissionDTO {

        Long memberId;
    }
}
