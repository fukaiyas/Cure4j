package cure4j.girls;

import java.util.Map;

public class CureBlack extends Girl.StandardGirl<CureBlack> {

    public CureBlack(Map<String, Object> config) {
        super(config);
    }

    public CureBlack dualAuroraWave(){
        return transform();
    }
}
