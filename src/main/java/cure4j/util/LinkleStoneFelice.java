package cure4j.util;

public enum LinkleStoneFelice implements LinkleStone{
    EMERALD(1, "emerald");
    //アレキサンドライト？

    private final int index;
    private final String configKey;

    LinkleStoneFelice(int index, String configKey){
        this.index = index;
        this.configKey = configKey;
    }

    public int index(){
        return index;
    }
    public String configKey(){
        return configKey;
    }
}
