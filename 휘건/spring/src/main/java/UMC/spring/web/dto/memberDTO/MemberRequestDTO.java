package UMC.spring.web.dto.memberDTO;

import UMC.spring.domain.enums.MemberGender;
import UMC.spring.domain.enums.MemberStatus;
import UMC.spring.domain.enums.SocialLoginType;
import UMC.spring.validation.annotation.ExistCategories;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
