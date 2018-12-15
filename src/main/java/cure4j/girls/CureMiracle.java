package cure4j.girls;

import cure4j.util.LinkleStone;

import java.util.Map;

public class CureMiracle extends Girl.MahoGirl {

    public CureMiracle(Map<String, Object> config) {
        super(config);
    }

    @Override
    public CureMiracle humanize(){
        super.humanize();
        return this;
    }

    @Override
    public CureMiracle transform(LinkleStone linkleStone){
        super.transform(linkleStone);
        return this;
    }

    @Override
    public CureMiracle cureUpRapapa(LinkleStone linkleStone){
        return transform(linkleStone);
    }
}
