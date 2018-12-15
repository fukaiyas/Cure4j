package cure4j.girls;

import java.util.Map;

public class CureMarine extends Girl.StandardGirl {

    public CureMarine(Map<String, Object> config){
        super(config);
    }

    @Override
    public CureMarine humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureMarine transform(){
        super.transform();
        return this;
    }

    public CureMarine openMyHeart(){
        return transform();
    }
}
