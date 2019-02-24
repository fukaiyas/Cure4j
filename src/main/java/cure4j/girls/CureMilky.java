package cure4j.girls;

import java.util.Map;

public class CureMilky extends Girl.StandardGirl<CureMilky> {

    public CureMilky(Map<String, Object> config) {
        super(config);
    }

    public CureMilky colorCharge(){
        return transform();
    }
}
