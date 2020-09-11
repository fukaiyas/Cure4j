package cure4j.girls;

import java.util.Map;

public class CureSparkle extends Girl.StandardGirl<CureSparkle> {

    public CureSparkle(Map<String, Object> config) {
        super(config);
    }

    public CureSparkle operation(){
        return transform();
    }
}
