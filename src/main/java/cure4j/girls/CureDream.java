package cure4j.girls;

import java.util.Map;

public class CureDream extends Girl.StandardGirl<CureDream> {

    public CureDream(Map<String, Object> config) {
        super(config);
    }

    public CureDream metamorphose(){
        return transform();
    }
}
