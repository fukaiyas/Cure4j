package cure4j.girls;

import java.util.Map;

public class CureFinale extends Girl.StandardGirl<CureFinale> {

    public CureFinale(Map<String, Object> config) {
        super(config);
    }

    public CureFinale delicioustandby(){
        return transform();
    }
}
