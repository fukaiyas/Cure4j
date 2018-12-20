package cure4j.girls;

import cure4j.util.LinkleStoneMiracleMagical;

import java.util.Map;

public class CureMiracle extends Girl.MahoGirl {

    public CureMiracle(Map<String, Object> config) {
        super(config, LinkleStoneMiracleMagical.values());
    }

    @Override
    public CureMiracle humanize(){
        super.humanize();
        return this;
    }

    public CureMiracle transform(LinkleStoneMiracleMagical linkleStoneMiracleMagical){
        super.transform(linkleStoneMiracleMagical);
        return this;
    }

    public CureMiracle cureUpRapapa(LinkleStoneMiracleMagical linkleStoneMiracleMagical){
        return transform(linkleStoneMiracleMagical);
    }
}
