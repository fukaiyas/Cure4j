package cure4j.girls;

import java.util.Map;

public class CureFriendy extends Girl.StandardGirl<CureFriendy> {

    public CureFriendy(Map<String, Object> config) {
        super(config);
    }

    public CureFriendy myEvolution(){
        return transform();
    }
}
