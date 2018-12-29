package cure4j.girls;

import java.util.Map;

public class CureAmour extends Girl.StandardGirl<CureAmour> {

    public CureAmour(Map<String, Object> config) {
        super(config);
    }

    public CureAmour heartKiratto(){
        return transform();
    }
}
