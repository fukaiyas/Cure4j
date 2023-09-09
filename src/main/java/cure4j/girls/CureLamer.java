package cure4j.girls;

import java.util.Map;

public class CureLamer extends Girl.TropicalGirl<CureLamer> {

    public CureLamer(Map<String, Object> config) {
        super(config);
    }

    public CureLamer tropicalChange(){
        return transform();
    }
}
