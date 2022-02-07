package cure4j.girls;

import java.util.Map;

public class CurePrecious extends Girl.StandardGirl<CurePrecious> {

    public CurePrecious(Map<String, Object> config) {
        super(config);
    }

    public CurePrecious delicioustandby(){
        return transform();
    }
}
