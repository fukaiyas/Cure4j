package cure4j.girls;

import java.util.Map;

public class CureBlack extends Girl.StandardGirl {

    public CureBlack(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureBlack humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureBlack transform(){
        super.transform();
        return this;
    }

    public CureBlack dualAuroraWave(){
        return transform();
    }
}
