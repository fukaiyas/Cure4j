package cure4j.girls;

import java.util.Map;

public class CureZukyoon extends Girl.StandardGirl<CureZukyoon> {

    public CureZukyoon(Map<String, Object> config) {
        super(config);
    }

    public CureZukyoon lightUp(){
        return transform();
    }
}
