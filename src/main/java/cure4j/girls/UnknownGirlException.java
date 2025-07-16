package cure4j.girls;

import java.io.Serial;

public class UnknownGirlException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 0L;
    public UnknownGirlException(String message){
        super(message);
    }
    public UnknownGirlException(String message, Throwable throwable){
        super(message, throwable);
    }
}
