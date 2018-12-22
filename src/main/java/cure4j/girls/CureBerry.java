package cure4j.girls;

import java.util.Map;

public class CureBerry extends Girl.StandardGirl<CureBerry> {

    public CureBerry(Map<String, Object> config) {
        super(config);
    }

    public CureBerry changePrecureBeatUp(){
        return transform();
    }

    public CureBerry change(){
        return transform();
    }

    public CureBerry beatUp(){
        return transform();
    }
}
