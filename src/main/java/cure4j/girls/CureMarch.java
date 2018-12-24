package cure4j.girls;

import java.util.Map;

public class CureMarch extends Girl.StandardGirl<CureMarch> {

    public CureMarch(Map<String, Object> config) {
        super(config);
    }

    public CureMarch smileCharge(){
        return transform();
    }
}
