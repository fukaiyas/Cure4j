package cure4j.girls;

import java.util.Map;

public class CureRouge extends Girl.StandardGirl<CureRouge> {

    public CureRouge(Map<String, Object> config) {
        super(config);
    }

    public CureRouge metamorphose(){
        return transform();
    }
}
