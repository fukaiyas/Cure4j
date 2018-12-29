package cure4j.girls;

import java.util.Map;

public class CureAnge extends Girl.StandardGirl<CureAnge> {

    public CureAnge(Map<String, Object> config) {
        super(config);
    }

    public CureAnge heartKiratto(){
        return transform();
    }
}
