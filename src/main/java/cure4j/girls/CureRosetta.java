package cure4j.girls;

import java.util.Map;

public class CureRosetta extends Girl.StandardGirl<CureRosetta> {

    public CureRosetta(Map<String, Object> config) {
        super(config);
    }

    public CureRosetta loveLink(){
        return transform();
    }
}
