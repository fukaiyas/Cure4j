package cure4j.girls;

import java.util.Map;

public class CureEarth extends Girl.StandardGirl<CureEarth> {

    public CureEarth(Map<String, Object> config) {
        super(config);
    }

    public CureEarth operation(){
        return transform();
    }
}
