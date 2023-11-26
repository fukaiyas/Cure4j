package cure4j.girls;

import java.util.Map;

public class CureMajesty extends Girl.StandardGirl<CureMajesty> {

    public CureMajesty(Map<String, Object> config) {
        super(config);
    }

    public CureMajesty skyMirageToneConnect(){
        return transform();
    }
}
