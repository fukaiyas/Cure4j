package cure4j.girls;

import java.util.Map;

public class CureKyunKyun extends Girl.StandardGirl<CureKyunKyun> {

    public CureKyunKyun(Map<String, Object> config) {
        super(config);
    }

    public CureKyunKyun lightUp(){
        return transform();
    }
}
