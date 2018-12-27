package cure4j.girls;

import java.util.Map;

public class CureFortune extends Girl.StandardGirl<CureFortune> {

    public CureFortune(Map<String, Object> config) {
        super(config);
    }

    public CureFortune kirarinStarSymphony(){
        return transform();
    }
}
