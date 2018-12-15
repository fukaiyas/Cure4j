package cure4j.girls;

import java.util.Map;

public class CureSunshine extends Girl.StandardGirl {

    public CureSunshine(Map<String, Object> config){
        super(config);
    }

    @Override
    public CureSunshine humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureSunshine transform(){
        super.transform();
        return this;
    }

    public CureSunshine openMyHeart(){
        return transform();
    }
}
