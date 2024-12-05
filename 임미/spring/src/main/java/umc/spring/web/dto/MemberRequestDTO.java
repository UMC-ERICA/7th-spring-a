package umc.spring.web.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.enumClass.Gender;
import umc.spring.domain.enumClass.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{

        String name;

        Integer gender;

        String password;

        LocalDate birthDate;

        String email;

        @ExistCategories
        List<Long> preferCategory;

        @NotNull
        Role role;

        LocalDate birthYear;
        LocalDate birthMonth;
        LocalDate birthDay;

        String address;
        String specAddress;


    }
}
