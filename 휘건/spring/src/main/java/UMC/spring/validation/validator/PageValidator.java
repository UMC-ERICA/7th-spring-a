package UMC.spring.validation.validator;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.validation.annotation.PageValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageValidator implements ConstraintValidator<PageValid, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            // 기본 ConstraintViolation 메시지 비활성화
            context.disableDefaultConstraintViolation();
            // 사용자 정의 메시지 설정
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_VALIDATION_ERROR.toString())
                    .addConstraintViolation();
            return false; // 검증 실패
        }
        return true; // 검증 성공
    }
}
