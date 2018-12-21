package cure4j.girls;

import java.util.Map;

public class CureWhite extends Girl.StandardGirl<CureWhite> {

    public CureWhite(Map<String, Object> config) {
        super(config);
    }

    public CureWhite dualAuroraWave(){
        return transform();
    }
}
