package cure4j.girls;

import java.util.Map;

public class CureLemonade extends Girl.StandardGirl<CureLemonade> {

    public CureLemonade(Map<String, Object> config) {
        super(config);
    }

    public CureLemonade metamorphose(){
        return transform();
    }
}
