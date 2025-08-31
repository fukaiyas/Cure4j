package cure4j.girls;

import java.util.Map;

public class CureWink extends Girl.StandardGirl<CureWink> {

    public CureWink(Map<String, Object> config) {
        super(config);
    }

    public CureWink lightUp(){
        return transform();
    }
}
