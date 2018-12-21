package cure4j.girls;

import java.util.Map;

public class CureSunshine extends Girl.StandardGirl<CureSunshine> {

    public CureSunshine(Map<String, Object> config){
        super(config);
    }

    public CureSunshine openMyHeart(){
        return transform();
    }
}
