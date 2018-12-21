package cure4j.girls;

import java.util.Map;

public class CureMarine extends Girl.StandardGirl<CureMarine> {

    public CureMarine(Map<String, Object> config){
        super(config);
    }

    public CureMarine openMyHeart(){
        return transform();
    }
}
