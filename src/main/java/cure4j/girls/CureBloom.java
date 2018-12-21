package cure4j.girls;

import java.util.Map;

public class CureBloom extends Girl.StandardGirl<CureBloom> {

    public CureBloom(Map<String, Object> config) {
        super(config);
    }

    public CureBloom dualSpiritualPower(){
        return transform();
    }
}
