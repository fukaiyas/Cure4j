package cure4j.girls;

import java.util.Map;

public class CureMoonlight extends Girl.StandardGirl<CureMoonlight> {

    public CureMoonlight(Map<String, Object> config){
        super(config);
    }

    public CureMoonlight openMyHeart(){
        return transform();
    }
}
