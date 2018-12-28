package cure4j.girls;

import java.util.Map;

public class CureFlora extends Girl.StandardGirl<CureFlora> {

    public CureFlora(Map<String, Object> config) {
        super(config);
    }

    public CureFlora princessEngage(){
        return transform();
    }
}
