package umc.spring.example.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.example.repository.storeRepository.StoreRepository;
import umc.spring.example.validation.annotation.ExistStore;

@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        // storeId가 null인 경우 유효하지 않음
        if (storeId == null) {
            return false;
        }
        // 데이터베이스에서 storeId로 가게를 조회하여 존재 여부를 확인
        return storeRepository.existsById(storeId);
    }
}