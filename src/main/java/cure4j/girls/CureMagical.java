package cure4j.girls;

import cure4j.util.LinkleStone;

import java.util.Map;

public class CureMagical extends Girl.MahoGirl {

    public CureMagical(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureMagical humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureMagical transform(LinkleStone linkleStone){
        super.transform(linkleStone);
        return this;
    }

    @Override
    public CureMagical cureUpRapapa(LinkleStone linkleStone){
        return transform(linkleStone);
    }
}
