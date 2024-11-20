package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStores, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {
        try {
            if (values == null) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.getMessage()).addConstraintViolation();
                return false;
            }

            boolean isValid = storeRepository.existsById(values);
            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.getMessage()).addConstraintViolation();
            }

            return isValid;
        } catch (Exception ex) {
            return false;
        }
    }
}
