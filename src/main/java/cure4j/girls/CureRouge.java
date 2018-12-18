package cure4j.girls;

import java.util.Map;

public class CureRouge extends Girl.StandardGirl {

    public CureRouge(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureRouge humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureRouge transform(){
        super.transform();
        return this;
    }

    public CureRouge metamorphose(){
        return transform();
    }
}
