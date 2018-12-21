package cure4j.girls;

import java.util.Map;

public class CureBlossom extends Girl.StandardGirl<CureBlossom> {

    public CureBlossom(Map<String, Object> config){
        super(config);
    }

    public CureBlossom openMyHeart(){
        return transform();
    }
}
