package cure4j.series;

@SuppressWarnings("serial")
public class UnknownMovieException extends RuntimeException{
    public UnknownMovieException(String message){
        super(message);
    }
    public UnknownMovieException(String message, Throwable throwable){
        super(message, throwable);
    }
}
