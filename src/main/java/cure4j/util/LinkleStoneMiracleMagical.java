package cure4j.util;

/**
 * LinkleStone for cure miracle and cure magical.
 */
public enum LinkleStoneMiracleMagical implements LinkleStone {
    /** diamond */
    DIAMOND(1, "diamond"),
    /** ruby */
    RUBY(2, "ruby"),
    /** sapphire */
    SAPPHIRE(3, "sapphire"),
    /** topaz */
    TOPAZ(4, "topaz");
    //TODO アレキサンドライト？

    private final int index;
    private final String configKey;

    /**
     * Constructs linkle stone with the specified index and configuration key.
     * @param index index(starts with 1)
     * @param configKey configuration key
     */
    LinkleStoneMiracleMagical(int index, String configKey){
        this.index = index;
        this.configKey = configKey;
    }

    /**
     * Index of transform styles.
     * @return index(starts with 1)
     */
    public int index(){
        return index;
    }

    /**
     * Configuration key of this linkle stone.
     * @return configuration key
     */
    public String configKey(){
        return configKey;
    }
}
