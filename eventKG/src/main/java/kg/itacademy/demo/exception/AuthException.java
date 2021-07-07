package kg.itacademy.demo.exception;

public class AuthException extends RuntimeException{
    public AuthException(String message) {
        super("Registration error: " + message);
    }
}

