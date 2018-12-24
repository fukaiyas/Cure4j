package cure4j.girls;

import java.util.Map;

public class CureSunny extends Girl.StandardGirl<CureSunny> {

    public CureSunny(Map<String, Object> config) {
        super(config);
    }

    public CureSunny smileCharge(){
        return transform();
    }
}
