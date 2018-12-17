package cure4j.girls;

import java.util.Map;

public class CureBright extends Girl.StandardGirl {

    public CureBright(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureBright humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureBright transform(){
        super.transform();
        return this;
    }

    public CureBright dualSpiritualPower(){
        return transform();
    }
}
