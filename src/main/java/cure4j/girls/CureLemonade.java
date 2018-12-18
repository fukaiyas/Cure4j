package cure4j.girls;

import java.util.Map;

public class CureLemonade extends Girl.StandardGirl {

    public CureLemonade(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureLemonade humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureLemonade transform(){
        super.transform();
        return this;
    }

    public CureLemonade metamorphose(){
        return transform();
    }
}
