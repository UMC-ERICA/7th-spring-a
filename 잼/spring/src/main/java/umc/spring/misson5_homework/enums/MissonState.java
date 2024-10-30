package umc.spring.misson5_homework.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MissonState {
    IN_PROGRESS("진행중"),
    COMPLETE("완료"),
    FAILED("미션 실패");

    private final String description;

}
