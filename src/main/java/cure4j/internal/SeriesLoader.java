package cure4j.internal;

import cure4j.series.Series;
import cure4j.series.UnknownSeriesException;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class SeriesLoader {

    @SuppressWarnings("unchecked")
    private static final Map<String, Series> SERIES_INSTANCE =
            LoaderUtil.loadYaml(
                    "/series.yml",
                    root -> root.entrySet().stream()
                            .collect(Collectors.toMap(
                                    es -> es.getKey(),
                                    es -> new Series((Map<String, Object>)es.getValue())
                            )));

    @SuppressWarnings("unchecked")
    public static final Map<String, Object> unmarked =
            LoaderUtil.loadYaml(
                    "/series.yml",
                    root -> (Map<String, Object>)root.get("unmarked"));

    public static Series get(String seriesName){
        if(!SERIES_INSTANCE.containsKey(seriesName)){
            throw new UnknownSeriesException("Unknown series : " + seriesName);
        }
        return SERIES_INSTANCE.get(seriesName);
    }

    public static Collection<Series> allEntries(){
        return SERIES_INSTANCE.values();
    }
}
