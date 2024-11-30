package umc.spring.misson.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.misson.annotation.custom.CustomPage;

public class PageValidator implements ConstraintValidator<CustomPage, Integer> {

    @Override
    public void initialize(CustomPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value <= 0) {
            return false;  // 페이지 번호가 0 이하일 경우 유효하지 않음
        }
        return true;
    }
}
