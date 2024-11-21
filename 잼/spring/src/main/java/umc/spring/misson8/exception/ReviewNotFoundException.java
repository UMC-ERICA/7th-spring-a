package umc.spring.misson8.exception;


public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException() {
    }

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
