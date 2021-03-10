package cure4j.girls;

import java.util.Map;

public class CurePapaya extends Girl.StandardGirl<CurePapaya> {

    public CurePapaya(Map<String, Object> config) {
        super(config);
    }

    public CurePapaya tropicalChange(){
        return transform();
    }
}
