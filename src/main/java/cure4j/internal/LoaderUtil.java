package cure4j.internal;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.function.Function;

public class LoaderUtil {

    private final Yaml YAML = new Yaml(new LocalDateConstructor());

    public static <T> Map<String, T> loadYaml(String path,
                                  Function<Map<String, Object>, Map<String, T>> function){

        try(Reader reader = new InputStreamReader(
                GirlsLoader.class.getResourceAsStream(path), Charset.forName("UTF-8"))) {
            Map<String, Object> root = new Yaml(new LocalDateConstructor()).load(reader);
            return function.apply(root);

        }catch(IOException ioEx){
            throw new UncheckedIOException(ioEx);
        }
    }
}
