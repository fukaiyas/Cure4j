package cure4j.girls;

import java.util.Map;

public class CureButterfly extends Girl.StandardGirl<CureButterfly> {

    public CureButterfly(Map<String, Object> config) {
        super(config);
    }

    public CureButterfly skyMirageToneConnect(){
        return transform();
    }
}
