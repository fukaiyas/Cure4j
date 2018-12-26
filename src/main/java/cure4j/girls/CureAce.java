package cure4j.girls;

import java.util.Map;

public class CureAce extends Girl.StandardGirl<CureAce> {

    public CureAce(Map<String, Object> config) {
        super(config);
    }

    public CureAce dressUp(){
        return transform();
    }
}
