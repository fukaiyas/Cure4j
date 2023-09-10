package cure4j.girls;

import java.util.Map;

public class CureSummer extends Girl.TropicalGirl<CureSummer> {

    public CureSummer(Map<String, Object> config) {
        super(config);
    }

    public CureSummer tropicalChange(){
        return transform();
    }
}
