package cure4j.girls;

import java.util.Map;

public class CureEtoile extends Girl.StandardGirl<CureEtoile> {

    public CureEtoile(Map<String, Object> config) {
        super(config);
    }

    public CureEtoile heartKiratto(){
        return transform();
    }
}
