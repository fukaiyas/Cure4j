package cure4j.girls;

import java.util.Map;

public class CureMacherie extends Girl.StandardGirl<CureMacherie> {

    public CureMacherie(Map<String, Object> config) {
        super(config);
    }

    public CureMacherie heartKiratto(){
        return transform();
    }
}
