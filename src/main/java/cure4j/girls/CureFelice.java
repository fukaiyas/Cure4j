package cure4j.girls;

import cure4j.util.LinkleStoneFelice;

import java.util.Map;

public class CureFelice extends Girl.MahoGirl<CureFelice> {

    public CureFelice(Map<String, Object> config) {
        super(config, LinkleStoneFelice.values());
    }

    public CureFelice cureUpRapapa(LinkleStoneFelice linkleStone){
        return transform(linkleStone);
    }
}
