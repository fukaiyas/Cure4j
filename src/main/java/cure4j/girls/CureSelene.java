package cure4j.girls;

import java.util.Map;

public class CureSelene extends Girl.StandardGirl<CureSelene> {

    public CureSelene(Map<String, Object> config) {
        super(config);
    }

    public CureSelene colorCharge(){
        return transform();
    }
}
