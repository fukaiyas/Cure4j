package cure4j.girls;

import java.util.Map;

public class CurePine extends Girl.StandardGirl<CurePine> {

    public CurePine(Map<String, Object> config) {
        super(config);
    }

    public CurePine changePrecureBeatUp(){
        return transform();
    }

    public CurePine change(){
        return transform();
    }

    public CurePine beatUp(){
        return transform();
    }
}
