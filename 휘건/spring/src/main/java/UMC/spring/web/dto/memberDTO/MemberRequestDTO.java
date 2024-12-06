package UMC.spring.web.dto.memberDTO;

import UMC.spring.domain.enums.Role;
import UMC.spring.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDTO {
        @NotBlank
        String memberName;
        @NotBlank
        String gender;
        @NotNull
        LocalDate birthdate;
        @NotBlank
        String memberAddress;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String phone;

        @NotBlank
        String password;

        @ExistCategories
        List<Long> preferCategory;

        @NotNull
        Role role;
    }
}
