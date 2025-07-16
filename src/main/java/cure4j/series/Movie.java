package cure4j.series;

import cure4j.girls.Girl;
import cure4j.internal.GirlsLoader;
import cure4j.internal.MoviesLoader;
import cure4j.util.Listream;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Movie {

    public static final Movie dx1 = MoviesLoader.get("dx1");
    public static final Movie dx2 = MoviesLoader.get("dx2");
    public static final Movie dx3 = MoviesLoader.get("dx3");
    public static final Movie ns1 = MoviesLoader.get("ns1");
    public static final Movie ns2 = MoviesLoader.get("ns2");
    public static final Movie ns3 = MoviesLoader.get("ns3");
    public static final Movie sc = MoviesLoader.get("sc");
    public static final Movie stmm = MoviesLoader.get("stmm");
    public static final Movie dreamStars = MoviesLoader.get("dream_stars");
    public static final Movie superStars = MoviesLoader.get("super_stars");
    public static final Movie memories = MoviesLoader.get("memories");
    public static final Movie miracleUniverse = MoviesLoader.get("miracle_universe");
    public static final Movie miracleLeap = MoviesLoader.get("miracle_leap");

    public static final Listream<Movie> movies = new Listream<>(
            MoviesLoader.allEntries().stream()
                .distinct()
                .sorted((m1, m2) -> m1.startedDate.compareTo(m2.startedDate))
                .collect(Collectors.toList()));

    public final String  title;
    public final LocalDate startedDate;
    public final Listream<Girl<?>> extraGirls;

    public static Movie find(String movieName){
        return MoviesLoader.get(movieName);
    }

    @SuppressWarnings("unchecked")
    public Movie(Map<String, Object> config){
        this.title = (String)config.get("title");
        this.startedDate = (LocalDate)config.get("started_date");
        List<String> girlNames = (List<String>)config.get("extra_girls");
        this.extraGirls = girlNames == null ? new Listream<>() :
                new Listream<>(girlNames.stream()
                    .map(name -> (Girl<?>)GirlsLoader.get(name))
                    .collect(Collectors.toList()));
    }

    @Override
    public String toString(){
        return title;
    }
    @Override
    public int hashCode(){
        return title.hashCode();
    }
    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof Movie)){
            return false;
        }
        Movie otherMovie = (Movie)other;
        return title.equals(otherMovie.title);
    }
}
