package cure4j.girls;

import java.util.Map;

public class CurePrism extends Girl.StandardGirl<CurePrism> {

    public CurePrism(Map<String, Object> config) {
        super(config);
    }

    public CurePrism skyMirageToneConnect(){
        return transform();
    }
}
