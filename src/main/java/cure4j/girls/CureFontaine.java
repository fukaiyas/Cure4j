package cure4j.girls;

import java.util.Map;

public class CureFontaine extends Girl.StandardGirl<CureFontaine> {

    public CureFontaine(Map<String, Object> config) {
        super(config);
    }

    public CureFontaine operation(){
        return transform();
    }
}
