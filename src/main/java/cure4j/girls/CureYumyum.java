package cure4j.girls;

import java.util.Map;

public class CureYumyum extends Girl.StandardGirl<CureYumyum> {

    public CureYumyum(Map<String, Object> config) {
        super(config);
    }

    public CureYumyum delicioustandby(){
        return transform();
    }
}
