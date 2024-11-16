package umc.spring.example.apiPayload;

public enum Code {
    OK(200, "Request was successful"),
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_ERROR(500, "Internal server error");

    private final int code;
    private final String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
