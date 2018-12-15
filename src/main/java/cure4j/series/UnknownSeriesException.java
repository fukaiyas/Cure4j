package cure4j.series;

public class UnknownSeriesException extends RuntimeException{
    public UnknownSeriesException(String message){
        super(message);
    }
    public UnknownSeriesException(String message, Throwable throwable){
        super(message, throwable);
    }
}
