package cure4j.util;

public enum LinkleStone {
    DIAMOND(1, "diamond"),
    RUBY(2, "ruby"),
    SAPPHIRE(3, "sapphire"),
    TOPAZ(4, "topaz");
    //アレキサンドライト？

    private final int index;
    private final String configKey;

    LinkleStone(int index, String configKey){
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
