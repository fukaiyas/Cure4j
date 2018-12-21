package cure4j.girls;

import cure4j.util.LinkleStoneMiracleMagical;

import java.util.Map;

public class CureMiracle extends Girl.MahoGirl<CureMiracle> {

    public CureMiracle(Map<String, Object> config) {
        super(config, LinkleStoneMiracleMagical.values());
    }

    public CureMiracle cureUpRapapa(LinkleStoneMiracleMagical linkleStone){
        return transform(linkleStone);
    }
}
