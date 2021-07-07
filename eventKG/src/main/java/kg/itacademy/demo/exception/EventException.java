package kg.itacademy.demo.exception;

public class EventException extends RuntimeException {
    public EventException(String message){
        super("Creation event error: " + message);}
}
