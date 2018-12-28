package cure4j.girls;

import java.util.Map;

public class CureMermaid extends Girl.StandardGirl<CureMermaid> {

    public CureMermaid(Map<String, Object> config) {
        super(config);
    }

    public CureMermaid princessEngage(){
        return transform();
    }
}
