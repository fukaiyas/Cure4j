package cure4j.girls;

import java.util.Map;

public class CureParfait extends Girl.StandardGirl<CureParfait> {

    public CureParfait(Map<String, Object> config) {
        super(config);
    }

    public CureParfait cureLaModeDecoration(){
        return transform();
    }
}
