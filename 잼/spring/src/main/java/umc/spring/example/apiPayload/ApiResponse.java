package umc.spring.example.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.example.apiPayload.code.BaseCode;
import umc.spring.example.apiPayload.code.status.SuccessStatus;
import umc.spring.example.dto.MemberResponseDTO;
import umc.spring.example.dto.StoreResponseDTO;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;

    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    //성공한 경우 응답 생성

    public static <T> ApiResponse<T> onSuccess(T result, Code ok) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result) {
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);
    }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(false, code, message, data);
    }

    public static ApiResponse<MemberResponseDTO.JoinResultDTO> onSuccess(MemberResponseDTO.JoinResultDTO joinResultDTO) {
        return new ApiResponse<>(
                true,
                SuccessStatus._OK.getCode(),
                SuccessStatus._OK.getMessage(),
                joinResultDTO
        );
    }

    public static ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> onSuccess(StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO) {
        return new ApiResponse<>(
                true,
                SuccessStatus._OK.getCode(),
                SuccessStatus._OK.getMessage(),
                reviewPreViewListDTO
        );
    }
}
