package cure4j.girls;

import java.util.Map;

public class CureBloom extends Girl.StandardGirl {

    public CureBloom(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureBloom humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureBloom transform(){
        super.transform();
        return this;
    }

    public CureBloom dualSpiritualPower(){
        return transform();
    }
}
