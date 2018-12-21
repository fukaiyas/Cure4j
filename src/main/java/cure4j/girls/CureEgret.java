package cure4j.girls;

import java.util.Map;

public class CureEgret extends Girl.StandardGirl<CureEgret> {

    public CureEgret(Map<String, Object> config) {
        super(config);
    }

    public CureEgret dualSpiritualPower(){
        return transform();
    }
}
