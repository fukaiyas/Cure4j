package cure4j.internal;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class LoaderUtil {

    private static final Yaml YAML = new Yaml(new LocalDateConstructor());

    public static <T> Map<String, T> loadYaml(String path,
                                  Function<Map<String, Object>, Map<String, T>> function){

        try(Reader reader = new InputStreamReader(
                GirlsLoader.class.getResourceAsStream(path), Charset.forName("UTF-8"))) {
            Map<String, Object> root = YAML.load(reader);
            return function.apply(root);

        }catch(IOException ioEx){
            throw new UncheckedIOException(ioEx);
        }
    }

    public static class LocalDateConstructor extends SafeConstructor {
        public LocalDateConstructor() {
            super();
            this.yamlConstructors.put(Tag.TIMESTAMP, new ConstructYamlTimestamp() {
                @Override
                public Object construct(Node node) {
                    Date date = (Date)super.construct(node);
                    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                }
            });
            if(Charset.defaultCharset().equals(Charset.forName("windows-31j"))){
                this.yamlConstructors.put(Tag.STR, new ConstructYamlStr(){
                    @Override
                    public Object construct(Node node) {
                        String str = (String)super.construct(node);
                        return str.replace('〜', '～');
                    }
                });
            }
        }
    }
}
