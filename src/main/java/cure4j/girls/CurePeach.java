package cure4j.girls;

import java.util.Map;

public class CurePeach extends Girl.StandardGirl<CurePeach> {

    public CurePeach(Map<String, Object> config) {
        super(config);
    }

    public CurePeach changePrecureBeatUp(){
        return transform();
    }

    public CurePeach change(){
        return transform();
    }

    public CurePeach beatUp(){
        return transform();
    }
}
