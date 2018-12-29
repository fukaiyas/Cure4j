package cure4j.girls;

import java.util.Map;

public class CureMacaron extends Girl.StandardGirl<CureMacaron> {

    public CureMacaron(Map<String, Object> config) {
        super(config);
    }

    public CureMacaron cureLaModeDecoration(){
        return transform();
    }
}
