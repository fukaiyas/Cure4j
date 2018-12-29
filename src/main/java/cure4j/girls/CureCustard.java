package cure4j.girls;

import java.util.Map;

public class CureCustard extends Girl.StandardGirl<CureCustard> {

    public CureCustard(Map<String, Object> config) {
        super(config);
    }

    public CureCustard cureLaModeDecoration(){
        return transform();
    }
}
