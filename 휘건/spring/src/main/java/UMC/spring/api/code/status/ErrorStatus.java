package UMC.spring.api.code.status;

import UMC.spring.api.code.BaseErrorCode;
import UMC.spring.api.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다"),

    //test 용
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트입니다"),
 
   // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수입니다."),

    // 가게 관련 에러
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "가게가 없습니다."),


    //음식 카테고리 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "PREFER4001", "알맞지 않은 음식 카테고리입니다."),

    //미션 관련 에러
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST,"MISSION4001", "해당 미션은 존재하지 않습니다."),
    MISSION_NOT_BELONGS_TO_STORE(HttpStatus.BAD_REQUEST, "MISSION4002", "지정된 가게에 해당 미션이 없습니다."),
    DUPLICATE_MISSION_IN_PROGRESS(HttpStatus.BAD_REQUEST, "MISSION4003", "이미 진행 중인 미션입니다."),

    // 회원이 수락한 미션 에러
    MEMBER_MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBERMISSION4001", "회원이 수락한 미션이 존재하지 않습니다."),
    MEMBER_MISSION_ALREADY_COMPLETED(HttpStatus.BAD_REQUEST, "MEMBERMISSION4002", "이미 완료된 미션입니다."),

    // 지역 관련 에러
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST,"REGION4001", "해당 주소는 존재하지 않습니다."),

    // 페이징 에러
    PAGE_VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"PAGE4001", "페이지 번호는 1 이상의 값이어야 합니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }


    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
