package cure4j.girls;

import java.util.Map;

public class CureSword extends Girl.StandardGirl<CureSword> {

    public CureSword(Map<String, Object> config) {
        super(config);
    }

    public CureSword loveLink(){
        return transform();
    }
}
