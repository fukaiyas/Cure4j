package cure4j.internal;

import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

import java.time.ZoneId;
import java.util.Date;

public class LocalDateConstructor extends SafeConstructor {
    public LocalDateConstructor() {
        super();
        this.yamlConstructors.put(Tag.TIMESTAMP, new ConstructYamlTimestamp() {
            @Override
            public Object construct(Node node) {
                Date date = (Date)super.construct(node);
                return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
        });
    }
}
