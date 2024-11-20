package umc.spring.misson8.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.misson8.repository.MissionRepository;

@Component
public class MissionExistValidator implements ConstraintValidator<CustomValidation, Long> {
    private final MissionRepository missionRepository;

    public MissionExistValidator(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // Null 값은 유효하지 않음
        }
        return missionRepository.existsById(value); // 미션 존재 여부 확인
    }
}
