package kg.itacademy.demo.exception;

public class AuthException extends RuntimeException {
    private String message;

    public AuthException(String message) {
        super("Вы не можете сделать это: " + message);
    }
}

