package cure4j.girls;

import java.io.Serial;

public class RequireTransformException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public RequireTransformException(String message){
        super(message);
    }
    public RequireTransformException(String message, Throwable throwable){
        super(message, throwable);
    }
}
