package cure4j.girls;

import java.util.Map;

public class CureWing extends Girl.StandardGirl<CureWing> {

    public CureWing(Map<String, Object> config) {
        super(config);
    }

    public CureWing skyMirageToneConnect(){
        return transform();
    }
}
