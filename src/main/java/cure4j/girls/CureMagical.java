package cure4j.girls;

import cure4j.util.LinkleStoneMiracleMagical;

import java.util.Map;

public class CureMagical extends Girl.MahoGirl<CureMagical> {

    public CureMagical(Map<String, Object> config) {
        super(config, LinkleStoneMiracleMagical.values());
    }

    public CureMagical cureUpRapapa(LinkleStoneMiracleMagical linkleStone){
        return transform(linkleStone);
    }
}
