package cure4j.girls;

import java.util.Map;

public class CureCoral extends Girl.StandardGirl<CureCoral> {

    public CureCoral(Map<String, Object> config) {
        super(config);
    }

    public CureCoral tropicalChange(){
        return transform();
    }
}
