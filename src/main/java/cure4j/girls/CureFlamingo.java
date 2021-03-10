package cure4j.girls;

import java.util.Map;

public class CureFlamingo extends Girl.StandardGirl<CureFlamingo> {

    public CureFlamingo(Map<String, Object> config) {
        super(config);
    }

    public CureFlamingo tropicalChange(){
        return transform();
    }
}
