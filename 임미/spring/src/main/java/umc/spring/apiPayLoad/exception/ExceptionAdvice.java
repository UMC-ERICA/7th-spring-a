package umc.spring.apiPayLoad.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.apiPayLoad.code.ErrorReasonDTO;
import umc.spring.apiPayLoad.code.status.ErrorStatus;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        // 모든 에러 메시지를 추출
        String errorMessage = e.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .findFirst()
                .orElse("Invalid input");

        // ErrorStatus 결정 (기본 값은 BAD_REQUEST)
        ErrorStatus errorStatus = resolveErrorStatus(errorMessage, ErrorStatus._BAD_REQUEST);

        // 클라이언트 응답 형식 생성
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("isSuccess", false);
        responseBody.put("code", errorStatus.name());
        responseBody.put("message", errorStatus.getMessage());

        // 에러 메시지를 result에 담음
        Map<String, Object> result = new HashMap<>();
        result.put("errorMessage", errorMessage);
        responseBody.put("result", result);

        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String fieldName = fieldError.getField();
            String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
            errors.merge(fieldName, errorMessage, (existing, newMsg) -> existing + ", " + newMsg);
        });

        ApiResponse<Object> body = ApiResponse.onFailure(ErrorStatus._BAD_REQUEST.getCode(),
                ErrorStatus._BAD_REQUEST.getMessage(),
                errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(body);
    }


    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        log.error("Unhandled exception: {}", e.getMessage(), e);

        return handleExceptionInternalFalse(
                e,
                ErrorStatus._INTERNAL_SERVER_ERROR,
                HttpHeaders.EMPTY,
                ErrorStatus._INTERNAL_SERVER_ERROR.getHttpStatus(),
                request,
                e.getMessage()
        );
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> onThrowException(GeneralException generalException, HttpServletRequest request) {
        log.error("General exception: {}", generalException.getMessage(), generalException);

        ErrorReasonDTO errorReason = generalException.getErrorReasonHttpStatus();
        return handleExceptionInternal(generalException, errorReason, null, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(
            Exception e, ErrorReasonDTO reason, HttpHeaders headers, HttpServletRequest request) {
        ApiResponse<Object> body = ApiResponse.onFailure(reason.getCode(), reason.getMessage(), null);
        WebRequest webRequest = new ServletWebRequest(request);

        return super.handleExceptionInternal(e, body, headers, reason.getHttpStatus(), webRequest);
    }

    private ResponseEntity<Object> handleExceptionInternalFalse(
            Exception e, ErrorStatus errorStatus, HttpHeaders headers, HttpStatus status, WebRequest request, String errorPoint) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorStatus.getCode(), errorStatus.getMessage(), errorPoint);

        return super.handleExceptionInternal(e, body, headers, status, request);
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(
            Exception e, HttpHeaders headers, ErrorStatus errorStatus, WebRequest request, Map<String, String> errorArgs) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorStatus.getCode(), errorStatus.getMessage(), errorArgs);

        return super.handleExceptionInternal(e, body, headers, errorStatus.getHttpStatus(), request);
    }

    private ResponseEntity<Object> handleExceptionInternalConstraint(
            Exception e, ErrorStatus errorStatus, HttpHeaders headers, WebRequest request) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorStatus.getCode(), errorStatus.getMessage(), null);

        return super.handleExceptionInternal(e, body, headers, errorStatus.getHttpStatus(), request);
    }

    private ErrorStatus resolveErrorStatus(String errorMessage, ErrorStatus defaultStatus) {
        try {
            return ErrorStatus.valueOf(errorMessage);
        } catch (IllegalArgumentException ex) {
            log.warn("Invalid error status '{}', using default: {}", errorMessage, defaultStatus);
            return defaultStatus;
        }
    }


}
