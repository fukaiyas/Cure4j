package cure4j.series;

public class UnknownMovieException extends RuntimeException{
    public UnknownMovieException(String message){
        super(message);
    }
    public UnknownMovieException(String message, Throwable throwable){
        super(message, throwable);
    }
}
