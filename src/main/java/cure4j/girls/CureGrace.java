package cure4j.girls;

import java.util.Map;

public class CureGrace extends Girl.StandardGirl<CureGrace> {

    public CureGrace(Map<String, Object> config) {
        super(config);
    }

    public CureGrace operation(){
        return transform();
    }
}
