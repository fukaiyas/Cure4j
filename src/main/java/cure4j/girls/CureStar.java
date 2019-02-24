package cure4j.girls;

import java.util.Map;

public class CureStar extends Girl.StandardGirl<CureStar> {

    public CureStar(Map<String, Object> config) {
        super(config);
    }

    public CureStar colorCharge(){
        return transform();
    }
}
