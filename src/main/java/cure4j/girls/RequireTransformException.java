package cure4j.girls;

public class RequireTransformException extends RuntimeException{
    public RequireTransformException(String message){
        super(message);
    }
    public RequireTransformException(String message, Throwable throwable){
        super(message, throwable);
    }
}
