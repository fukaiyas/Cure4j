package cure4j.girls;

import java.util.Map;

public class CureAqua extends Girl.StandardGirl<CureAqua> {

    public CureAqua(Map<String, Object> config) {
        super(config);
    }

    public CureAqua metamorphose(){
        return transform();
    }
}
