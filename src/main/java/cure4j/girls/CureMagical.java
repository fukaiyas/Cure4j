package cure4j.girls;

import cure4j.util.LinkleStoneMiracleMagical;

import java.util.Map;

public class CureMagical extends Girl.MahoGirl {

    public CureMagical(Map<String, Object> config) {
        super(config, LinkleStoneMiracleMagical.values());
    }

    @Override
    public CureMagical humanize(){
        super.humanize();
        return this;
    }

    public CureMagical transform(LinkleStoneMiracleMagical linkleStoneMiracleMagical){
        super.transform(linkleStoneMiracleMagical);
        return this;
    }

    public CureMagical cureUpRapapa(LinkleStoneMiracleMagical linkleStoneMiracleMagical){
        return transform(linkleStoneMiracleMagical);
    }
}
