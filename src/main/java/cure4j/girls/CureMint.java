package cure4j.girls;

import java.util.Map;

public class CureMint extends Girl.StandardGirl<CureMint> {

    public CureMint(Map<String, Object> config) {
        super(config);
    }

    public CureMint metamorphose(){
        return transform();
    }
}
