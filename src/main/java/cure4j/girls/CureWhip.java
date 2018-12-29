package cure4j.girls;

import java.util.Map;

public class CureWhip extends Girl.StandardGirl<CureWhip> {

    public CureWhip(Map<String, Object> config) {
        super(config);
    }

    public CureWhip cureLaModeDecoration(){
        return transform();
    }
}
