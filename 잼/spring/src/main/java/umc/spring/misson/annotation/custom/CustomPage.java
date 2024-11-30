package umc.spring.misson.annotation.custom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.misson.annotation.validator.PageValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PageValidator.class)
public @interface CustomPage {

    //유효성 검사 실패 시 반환할 기본 메세지 정의
    String message() default "타당하지 않은 페이지 숫자입니다. 0보다 큰 값을 입력해주세요.";

    //유효성 검사 그룹을 지정하는데 사용
    Class<?>[] groups() default {};

    //유효성 검사에 대한 추가 정보 제공
    Class<? extends Payload>[] payload() default {};

}
