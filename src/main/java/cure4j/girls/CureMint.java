package cure4j.girls;

import java.util.Map;

public class CureMint extends Girl.StandardGirl {

    public CureMint(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureMint humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureMint transform(){
        super.transform();
        return this;
    }

    public CureMint metamorphose(){
        return transform();
    }
}
