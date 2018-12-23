package cure4j.girls;

import java.util.Map;

public class CureRhythm extends Girl.StandardGirl<CureRhythm> {

    public CureRhythm(Map<String, Object> config) {
        super(config);
    }

    public CureRhythm letsPlayPrecureModulation(){
        return transform();
    }

    public CureRhythm letsPlay(){
        return transform();
    }

    public CureRhythm modulation(){
        return transform();
    }
}
