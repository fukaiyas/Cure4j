package cure4j.girls;

import java.util.Map;

public class CureBright extends Girl.StandardGirl<CureBright> {

    public CureBright(Map<String, Object> config) {
        super(config);
    }

    public CureBright dualSpiritualPower(){
        return transform();
    }
}
