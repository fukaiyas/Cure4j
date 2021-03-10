package cure4j.series;

@SuppressWarnings("serial")
public class NotOnAirException extends RuntimeException{
    public NotOnAirException(String message){
        super(message);
    }
    public NotOnAirException(String message, Throwable throwable){
        super(message, throwable);
    }
}
