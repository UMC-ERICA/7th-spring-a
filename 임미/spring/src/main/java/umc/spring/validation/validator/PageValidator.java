package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.PageHandler;
import umc.spring.validation.annotation.PageValid;

import java.util.List;

@Component
public class PageValidator implements ConstraintValidator<PageValid, Integer> {


    @Override
    public void initialize(PageValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            // 기본 메시지 사용
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_BAD_REQUEST.getMessage())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
