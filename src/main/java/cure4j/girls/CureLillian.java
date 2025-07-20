package cure4j.girls;

import java.util.Map;

public class CureLillian extends Girl.StandardGirl<CureLillian> {

    public CureLillian(Map<String, Object> config) {
        super(config);
    }

    public CureLillian myEvolution(){
        return transform();
    }
}
