package cure4j.girls;

import java.util.Map;

public class CureWhite extends Girl.StandardGirl {

    public CureWhite(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureWhite humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureWhite transform(){
        super.transform();
        return this;
    }

    public CureWhite dualAuroraWave(){
        return transform();
    }
}
