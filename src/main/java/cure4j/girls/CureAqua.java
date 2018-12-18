package cure4j.girls;

import java.util.Map;

public class CureAqua extends Girl.StandardGirl {

    public CureAqua(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureAqua humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureAqua transform(){
        super.transform();
        return this;
    }

    public CureAqua metamorphose(){
        return transform();
    }
}
