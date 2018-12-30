package cure4j.girls;

public class UnknownGirlException extends RuntimeException{
    public UnknownGirlException(String message){
        super(message);
    }
    public UnknownGirlException(String message, Throwable throwable){
        super(message, throwable);
    }
}
