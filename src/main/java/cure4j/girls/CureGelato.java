package cure4j.girls;

import java.util.Map;

public class CureGelato extends Girl.StandardGirl<CureGelato> {

    public CureGelato(Map<String, Object> config) {
        super(config);
    }

    public CureGelato cureLaModeDecoration(){
        return transform();
    }
}
