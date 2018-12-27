package cure4j.girls;

import java.util.Map;

public class CurePrincess extends Girl.StandardGirl<CurePrincess> {

    public CurePrincess(Map<String, Object> config) {
        super(config);
    }

    public CurePrincess kururinMirrorChange(){
        return transform();
    }
}
