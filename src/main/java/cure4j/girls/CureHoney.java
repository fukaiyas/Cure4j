package cure4j.girls;

import java.util.Map;

public class CureHoney extends Girl.StandardGirl<CureHoney> {

    public CureHoney(Map<String, Object> config) {
        super(config);
    }

    public CureHoney kururinMirrorChange(){
        return transform();
    }
}
