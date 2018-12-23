package cure4j.girls;

import java.util.Map;

public class CureMuse extends Girl.StandardGirl<CureMuse> {

    public CureMuse(Map<String, Object> config) {
        super(config);
    }

    public CureMuse letsPlayPrecureModulation(){
        return transform();
    }

    public CureMuse letsPlay(){
        return transform();
    }

    public CureMuse modulation(){
        return transform();
    }
}
