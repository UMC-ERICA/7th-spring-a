package umc.spring.misson8.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.misson8.repository.RestaurantRepository;

@Component
public class RestaurantExistValidator implements ConstraintValidator<CustomValidation, Long> {
    private final RestaurantRepository restaurantRepository;

    public RestaurantExistValidator(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // Null 값은 유효하지 않음
        }
        return restaurantRepository.existsById(value); // 가게 존재 여부 확인
    }
}
