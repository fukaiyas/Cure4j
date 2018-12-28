package cure4j.girls;

import java.util.Map;

public class CureTwinkle extends Girl.StandardGirl<CureTwinkle> {

    public CureTwinkle(Map<String, Object> config) {
        super(config);
    }

    public CureTwinkle princessEngage(){
        return transform();
    }
}
