package cure4j.girls;

import java.util.Map;

public class CureScarlet extends Girl.StandardGirl<CureScarlet> {

    public CureScarlet(Map<String, Object> config) {
        super(config);
    }

    public CureScarlet princessEngage(){
        return transform();
    }
}
