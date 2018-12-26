package cure4j.girls;

import java.util.Map;

public class CureHeart extends Girl.StandardGirl<CureHeart> {

    public CureHeart(Map<String, Object> config) {
        super(config);
    }

    public CureHeart loveLink(){
        return transform();
    }
}
