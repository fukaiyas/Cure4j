package cure4j.girls;

import java.util.Map;

public class CureChocolat extends Girl.StandardGirl<CureChocolat> {

    public CureChocolat(Map<String, Object> config) {
        super(config);
    }

    public CureChocolat cureLaModeDecoration(){
        return transform();
    }
}
