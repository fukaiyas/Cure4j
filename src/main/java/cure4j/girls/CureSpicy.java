package cure4j.girls;

import java.util.Map;

public class CureSpicy extends Girl.StandardGirl<CureSpicy> {

    public CureSpicy(Map<String, Object> config) {
        super(config);
    }

    public CureSpicy delicioustandby(){
        return transform();
    }
}
