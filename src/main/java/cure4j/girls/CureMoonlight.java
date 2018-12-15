package cure4j.girls;

import java.util.Map;

public class CureMoonlight extends Girl.StandardGirl {

    public CureMoonlight(Map<String, Object> config){
        super(config);
    }

    @Override
    public CureMoonlight humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureMoonlight transform(){
        super.transform();
        return this;
    }

    public CureMoonlight openMyHeart(){
        return transform();
    }
}
