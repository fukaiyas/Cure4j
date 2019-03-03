package cure4j.girls;

import java.util.Map;

public class CureSoleil extends Girl.StandardGirl<CureSoleil> {

    public CureSoleil(Map<String, Object> config) {
        super(config);
    }

    public CureSoleil colorCharge(){
        return transform();
    }
}
