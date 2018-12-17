package cure4j.girls;

import java.util.Map;

public class CureWindy extends Girl.StandardGirl {

    public CureWindy(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureWindy humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureWindy transform(){
        super.transform();
        return this;
    }

    public CureWindy dualSpiritualPower(){
        return transform();
    }
}
