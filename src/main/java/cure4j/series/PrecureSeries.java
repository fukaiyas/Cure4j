package cure4j.series;

import cure4j.girls.Girl;
import cure4j.internal.DateUtil;
import cure4j.internal.SeriesLoader;
import cure4j.util.Listream;

import java.time.LocalDate;
import java.util.List;
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

    public Series find(String seriesName){
        return SeriesLoader.get(seriesName);
    }

    public final Listream<Series> series = new Listream<>(
            SeriesLoader.allEntries().stream()
                    .distinct()
                    .sorted((s1, s2) -> s1.startedDate.compareTo(s2.startedDate))
                    .collect(Collectors.toList()));

    public Listream<Girl<?>> allStars(){
        return allStars(DateUtil.currentDate());
    }
    public Listream<Girl<?>> allStars(String date){
        return allStars(DateUtil.parseDate(date));
    }
    public Listream<Girl<?>> allStars(Movie movie){
        //FIXME 本来はオールスターズ系(3世代系じゃない)だけ指定可能にしたいかも？
        return new Listream<>(allStars(movie.startedDate), movie.extraGirls);
    }
    public Listream<Girl<?>> allStars(LocalDate date){
        //FIXME (本来はmemories決め打ちではなく、オールスターズとしての最新の作品の日付にするべき？)
        LocalDate lastDate = date.isBefore(Movie.memories.startedDate) ?
                date : Movie.memories.startedDate;
        List<Girl<?>> extraGirls = Movie.movies
                .flatMap(m -> m.extraGirls.stream())
                .distinct()
                .collect(Collectors.toList());
        return Girl.allGirls()
                .filter(g -> g.firstCreatedDate().isBefore(lastDate))
                .filter(g -> !extraGirls.contains(g));
    }

    public Series now(){
        return current();
    }
    public Series current(){
        return when(DateUtil.currentDate());
    }
    public Series when(String date){
        return when(DateUtil.parseDate(date));
    }
    public Series when(LocalDate date){
        return series.filter(s -> s.isOnAir(date))
                .findFirst()
                .orElseThrow(() -> new NotOnAirException("Not on air precure!"));
    }
}
