package cure4j.girls;

import java.util.Map;

public class CureWindy extends Girl.StandardGirl<CureWindy> {

    public CureWindy(Map<String, Object> config) {
        super(config);
    }

    public CureWindy dualSpiritualPower(){
        return transform();
    }
}
