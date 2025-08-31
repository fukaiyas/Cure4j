package cure4j.girls;

import java.util.Map;

public class CureKiss extends Girl.StandardGirl<CureKiss> {

    public CureKiss(Map<String, Object> config) {
        super(config);
    }

    public CureKiss lightUp(){
        return transform();
    }
}
