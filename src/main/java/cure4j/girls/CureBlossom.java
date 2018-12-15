package cure4j.girls;

import java.util.Map;

public class CureBlossom extends Girl.StandardGirl {

    public CureBlossom(Map<String, Object> config){
        super(config);
    }

    @Override
    public CureBlossom humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureBlossom transform(){
        super.transform();
        return this;
    }

    public CureBlossom openMyHeart(){
        return transform();
    }
}
