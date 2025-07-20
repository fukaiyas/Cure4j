package cure4j.girls;

import java.util.Map;

public class CureWonderful extends Girl.StandardGirl<CureWonderful> {

    public CureWonderful(Map<String, Object> config) {
        super(config);
    }

    public CureWonderful myEvolution(){
        return transform();
    }
}
