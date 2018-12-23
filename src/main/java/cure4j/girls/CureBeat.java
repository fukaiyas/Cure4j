package cure4j.girls;

import java.util.Map;

public class CureBeat extends Girl.StandardGirl<CureBeat> {

    public CureBeat(Map<String, Object> config) {
        super(config);
    }

    public CureBeat letsPlayPrecureModulation(){
        return transform();
    }

    public CureBeat letsPlay(){
        return transform();
    }

    public CureBeat modulation(){
        return transform();
    }
}
