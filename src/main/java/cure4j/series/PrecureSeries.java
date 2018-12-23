package cure4j.series;

import cure4j.girls.Girl;
import cure4j.internal.MoviesLoader;
import cure4j.internal.SeriesLoader;
import cure4j.util.Listream;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class PrecureSeries extends Series {

    public PrecureSeries(Map<String, Object> config) {
        super(config);
    }

    public final Series unmarked = SeriesLoader.get("unmarked");
    public final Series maxHeart = SeriesLoader.get("max_heart");
    public final Series splashStar = SeriesLoader.get("splash_star");
    public final Series yes = SeriesLoader.get("yes");
    public final Series yesGogo = SeriesLoader.get("yes_gogo");
    public final Series fresh = SeriesLoader.get("fresh");
    public final Series heartCatch = SeriesLoader.get("heart_catch");
    public final Series suite = SeriesLoader.get("suite");
    public final Series smile = SeriesLoader.get("smile");
    public final Series dokidoki = SeriesLoader.get("dokidoki");
    public final Series happinessCharge = SeriesLoader.get("happiness_charge");
    public final Series goPrincess = SeriesLoader.get("go_princess");
    public final Series mahoGirls = SeriesLoader.get("maho_girls");
    public final Series aLaMode = SeriesLoader.get("a_la_mode");
    public final Series hugtto = SeriesLoader.get("hugtto");

    public Series getSeries(String seriesName){
        return SeriesLoader.get(seriesName);
    }

    public final Listream<Series> series = new Listream<>(
            SeriesLoader.allEntries().stream()
                    .distinct()
                    .sorted((s1, s2) -> s1.startedDate.compareTo(s2.startedDate))
                    .collect(Collectors.toList()));

    public Listream<Girl> allStars(){
        return allStars(LocalDate.now());
    }
    public Listream<Girl> allStars(String date){
        return allStars(LocalDate.parse(date));
    }
    public Listream<Girl> allStars(Movie movie){
        return allStars(movie.startedDate);
    }
    public Listream<Girl> allStars(LocalDate date){
        return null;//FIXME
    }

    public Series now(){
        return current();
    }
    public Series current(){
        return series.filter(Series::isOnAir)
                .findFirst()
                .orElseThrow(() -> new NotOnAirException("Not on air precure!"));
    }

}
