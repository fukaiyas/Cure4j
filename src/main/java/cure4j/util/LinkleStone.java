package cure4j.util;

/**
 * LinkleStone is transform item for Maho Girl Precure.
 */
public interface LinkleStone {

    /**
     * Index of transform styles.
     * @return index(starts with 1)
     */
    int index();

    /**
     * Configuration key of this linkle stone.
     * @return configuration key
     */
    String configKey();
}
