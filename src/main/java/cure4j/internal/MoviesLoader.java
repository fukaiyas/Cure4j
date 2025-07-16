package cure4j.internal;

import cure4j.series.Movie;
import cure4j.series.UnknownMovieException;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class MoviesLoader {

    @SuppressWarnings("unchecked")
    private static final Map<String, Movie> MOVIES_INSTANCE =
            LoaderUtil.loadYaml(
                    "/movies.yml",
                    root -> root.entrySet().stream()
                            .collect(Collectors.toMap(
                                    es -> es.getKey(),
                                    es -> new Movie((Map<String, Object>)es.getValue())
                            )));

    public static synchronized Movie get(String movieName){
        if(!MOVIES_INSTANCE.containsKey(movieName)){
            throw new UnknownMovieException("Unknown movie : " + movieName);
        }
        return MOVIES_INSTANCE.get(movieName);
    }
    public static Collection<Movie> allEntries(){
        return MOVIES_INSTANCE.values();
    }
}
