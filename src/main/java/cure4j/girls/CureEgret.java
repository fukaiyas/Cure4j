package cure4j.girls;

import java.util.Map;

public class CureEgret extends Girl.StandardGirl {

    public CureEgret(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureEgret humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureEgret transform(){
        super.transform();
        return this;
    }

    public CureEgret dualSpiritualPower(){
        return transform();
    }
}
