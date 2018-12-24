package cure4j.girls;

import java.util.Map;

public class CureHappy extends Girl.StandardGirl<CureHappy> {

    public CureHappy(Map<String, Object> config) {
        super(config);
    }

    public CureHappy smileCharge(){
        return transform();
    }
}
