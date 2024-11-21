package umc.spring.misson8.exception;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException() {
    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
