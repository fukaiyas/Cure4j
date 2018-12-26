package cure4j.girls;

import java.util.Map;

public class CureDiamond extends Girl.StandardGirl<CureDiamond> {

    public CureDiamond(Map<String, Object> config) {
        super(config);
    }

    public CureDiamond loveLink(){
        return transform();
    }
}
