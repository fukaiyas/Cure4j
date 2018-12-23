package cure4j.girls;

import java.util.Map;

public class CureMelody extends Girl.StandardGirl<CureMelody> {

    public CureMelody(Map<String, Object> config) {
        super(config);
    }

    public CureMelody letsPlayPrecureModulation(){
        return transform();
    }

    public CureMelody letsPlay(){
        return transform();
    }

    public CureMelody modulation(){
        return transform();
    }
}
