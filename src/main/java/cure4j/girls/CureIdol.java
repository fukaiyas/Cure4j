package cure4j.girls;

import java.util.Map;

public class CureIdol extends Girl.StandardGirl<CureIdol> {

    public CureIdol(Map<String, Object> config) {
        super(config);
    }

    public CureIdol lightUp(){
        return transform();
    }
}
