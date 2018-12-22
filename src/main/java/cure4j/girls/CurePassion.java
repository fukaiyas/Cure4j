package cure4j.girls;

import java.util.Map;

public class CurePassion extends Girl.StandardGirl<CurePassion> {

    public CurePassion(Map<String, Object> config) {
        super(config);
    }

    public CurePassion changePrecureBeatUp(){
        return transform();
    }

    public CurePassion change(){
        return transform();
    }

    public CurePassion beatUp(){
        return transform();
    }
}
