package cure4j.girls;

import java.util.Map;

public class MilkyRose extends Girl.StandardGirl<MilkyRose> {

    public MilkyRose(Map<String, Object> config) {
        super(config);
    }

    public MilkyRose skyRoseTranslate(){
        return transform();
    }

    public MilkyRose translate(){
        return transform();
    }
}
