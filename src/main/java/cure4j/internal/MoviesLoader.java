package cure4j.internal;

import cure4j.series.Movie;
import cure4j.series.UnknownMovieException;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class MoviesLoader {

    private static final Map<String, Movie> MOVIES_INSTANCE = load();

    public static synchronized Movie get(String movieName){
        if(!MOVIES_INSTANCE.containsKey(movieName)){
            throw new UnknownMovieException("Unknown movie : " + movieName);
        }
        return MOVIES_INSTANCE.get(movieName);
    }
    public static Map<String, Movie> load(){
        Map<String, Movie> result = new HashMap<>();
        try(Reader reader = new InputStreamReader(
                GirlsLoader.class.getResourceAsStream("/movies.yml"), Charset.forName("UTF-8"))){
            Map<String, Object> root = new Yaml(new LocalDateConstructor()).load(reader);
            root.entrySet().stream()
                    .forEach(ks -> {
                        Movie movie = new Movie((Map<String, Object>)ks.getValue());
                        result.put(ks.getKey(), movie);
                    });

        }catch(Exception e){
            throw new RuntimeException("Unknown exception.", e);
        }
        return result;
    }
}
