package cure4j.girls;

import java.util.Map;

public class CureCosmo extends Girl.StandardGirl<CureCosmo> {

    public CureCosmo(Map<String, Object> config) {
        super(config);
    }

    public CureCosmo colorCharge(){
        return transform();
    }
}
