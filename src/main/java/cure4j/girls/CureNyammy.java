package cure4j.girls;

import java.util.Map;

public class CureNyammy extends Girl.StandardGirl<CureNyammy> {

    public CureNyammy(Map<String, Object> config) {
        super(config);
    }

    public CureNyammy myEvolution(){
        return transform();
    }
}
