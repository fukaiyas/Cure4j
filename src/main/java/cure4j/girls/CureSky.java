package cure4j.girls;

import java.util.Map;

public class CureSky extends Girl.StandardGirl<CureSky> {

    public CureSky(Map<String, Object> config) {
        super(config);
    }

    public CureSky skyMirageToneConnect(){
        return transform();
    }
}
