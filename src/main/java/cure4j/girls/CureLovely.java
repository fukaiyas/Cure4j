package cure4j.girls;

import java.util.Map;

public class CureLovely extends Girl.StandardGirl<CureLovely> {

    public CureLovely(Map<String, Object> config) {
        super(config);
    }

    public CureLovely kururinMirrorChange(){
        return transform();
    }
}
