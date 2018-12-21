package cure4j.girls;

import java.util.Map;

public class ShinyLuminous extends Girl.StandardGirl<ShinyLuminous> {

    public ShinyLuminous(Map<String, Object> config) {
        super(config);
    }

    public ShinyLuminous shiningStream(){
        return transform();
    }
}
