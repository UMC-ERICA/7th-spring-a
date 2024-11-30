package UMC.spring.validation.annotation;

import UMC.spring.validation.validator.PageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target( {ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PageValid {

    String message() default "페이지 번호는 1 이상이어야 합니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
