package UMC.spring.web.dto.memberDTO;

import UMC.spring.validation.annotation.ExistCategories;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO {

        String memberName;

        String gender;

        LocalDate birthdate;

        String memberAddress;

        String email;

        String phone;

        @ExistCategories
        List<Long> preferCategory;
    }
}
