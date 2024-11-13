package umc.spring.example.exception;

public class StoreNotFoundException  extends RuntimeException{
    public StoreNotFoundException() {
    }

    public StoreNotFoundException(String message) {
        super(message);
    }
}
