package umc.spring.misson8.exception;

public class MissonNotFoundException extends RuntimeException{
    public MissonNotFoundException() {
    }

    public MissonNotFoundException(String message) {
        super(message);
    }
}
