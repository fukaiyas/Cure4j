package cure4j.girls;

import java.util.Map;

public class ShinyLuminous extends Girl.StandardGirl {

    public ShinyLuminous(Map<String, Object> config) {
        super(config);
    }

    @Override
    public ShinyLuminous humanize(){
        super.humanize();
        return this;
    }

    @Override
    public ShinyLuminous transform(){
        super.transform();
        return this;
    }
}
