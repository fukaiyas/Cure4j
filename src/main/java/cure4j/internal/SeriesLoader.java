package cure4j.internal;

import cure4j.series.Series;
import cure4j.series.UnknownSeriesException;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SeriesLoader {

    private static final Map<String, Series> SERIES_INSTANCE = load();

    public static Map<String, Object> unmarked;

    public static Series get(String seriesName){
        if(!SERIES_INSTANCE.containsKey(seriesName)){
            throw new UnknownSeriesException("Unknown series : " + seriesName);
        }
        return SERIES_INSTANCE.get(seriesName);
    }

    public static Collection<Series> allEntries(){
        return SERIES_INSTANCE.values();
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Series> load(){
        Map<String, Series> result = new HashMap<>();
        try(Reader reader = new InputStreamReader(
                    GirlsLoader.class.getResourceAsStream("/series.yml"), Charset.forName("UTF-8"))){
            Map<String, Object> root = new Yaml(new LocalDateConstructor()).load(reader);
            unmarked = (Map<String, Object>)root.get("unmarked");
            return root.entrySet().stream()
                    .collect(Collectors.toMap(
                            es -> es.getKey(),
                            es -> new Series((Map<String, Object>)es.getValue())
                    ));

        }catch(Exception e){
            throw new RuntimeException("Unknown exception.", e);
        }
    }
}
