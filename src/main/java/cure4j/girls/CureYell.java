package cure4j.girls;

import java.util.Map;

public class CureYell extends Girl.StandardGirl<CureYell> {

    public CureYell(Map<String, Object> config) {
        super(config);
    }

    public CureYell heartKiratto(){
        return transform();
    }
}
