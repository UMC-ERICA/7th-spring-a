package umc.spring.validation.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.StoreExistValidator;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = StoreExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStores {

    String message() default "해당하는 상점이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
