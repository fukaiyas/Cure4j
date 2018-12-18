package cure4j.girls;

import java.util.Map;

public class MilkyRose extends Girl.StandardGirl {

    public MilkyRose(Map<String, Object> config) {
        super(config);
    }

    @Override
    public MilkyRose humanize(){
        super.humanize();
        return this;
    }

    @Override
    public MilkyRose transform(){
        super.transform();
        return this;
    }

    public MilkyRose skyRoseTranslate(){
        return transform();
    }

    //TODO translateのみでも変身したことがある？
}
