package cure4j.girls;

import java.util.Map;

public class CureBeauty extends Girl.StandardGirl<CureBeauty> {

    public CureBeauty(Map<String, Object> config) {
        super(config);
    }

    public CureBeauty smileCharge(){
        return transform();
    }
}
