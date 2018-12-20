package cure4j.girls;

import cure4j.util.LinkleStoneFelice;

import java.util.Map;

public class CureFelice extends Girl.MahoGirl {

    public CureFelice(Map<String, Object> config) {
        super(config, LinkleStoneFelice.values());
    }

    @Override
    public CureFelice humanize(){
        super.humanize();
        return this;
    }

    public CureFelice transform(LinkleStoneFelice linkleStone){
        super.transform(linkleStone);
        return this;
    }

    public CureFelice cureUpRapapa(LinkleStoneFelice linkleStone){
        return transform(linkleStone);
    }
}
