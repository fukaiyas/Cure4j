package cure4j.girls;

import java.util.Map;

public class CureDream extends Girl.StandardGirl {

    public CureDream(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureDream humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureDream transform(){
        super.transform();
        return this;
    }

    public CureDream metamorphose(){
        return transform();
    }
}
