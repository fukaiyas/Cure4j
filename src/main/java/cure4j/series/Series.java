package cure4j.series;

import cure4j.girls.Girl;
import cure4j.internal.GirlsLoader;
import cure4j.util.Listream;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Series {

    public final String seriesName;
    public final String title;
    public final LocalDate startedDate;
    public final LocalDate endedDate;
    public final Listream<? extends Girl> girls;

    public Series(Map<String, Object> config){
        this.seriesName = (String)config.get("series_name");
        this.title = (String)config.get("title");
        this.startedDate = (LocalDate)config.get("started_date");
        this.endedDate = (LocalDate)config.get("ended_date");
        List<String> girlNames = (List<String>)config.get("girls");
        this.girls= new Listream<>(girlNames.stream()
                .map(name -> (Girl)GirlsLoader.get(name))
                .collect(Collectors.toList()));
    }

    public boolean isOnAir(){
        return isOnAir(LocalDate.now());
    }
    public boolean isOnAir(String date){
        return isOnAir(LocalDate.parse(date));
    }
    public boolean isOnAir(LocalDate date){
        if(startedDate == null){
            return false;
        }
        boolean started = date.compareTo(startedDate) >= 0;
        if(endedDate == null){
            return started;
        }
        return started && endedDate.compareTo(date) >= 0;
    }

    @Override
    public String toString(){
        return seriesName;
    }
    @Override
    public int hashCode(){
        return seriesName.hashCode();
    }
    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof Series)){
            return false;
        }
        Series otherSeries = (Series)other;
        return seriesName.equals(otherSeries.seriesName);
    }
}
