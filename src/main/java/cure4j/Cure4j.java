package cure4j;

import cure4j.girls.*;
import cure4j.series.PrecureSeries;
import cure4j.internal.GirlsLoader;
import cure4j.internal.SeriesLoader;

public final class Cure4j {

    public static final PrecureSeries Precure = new PrecureSeries(SeriesLoader.unmarked);

    public static final class Cure{
        private Cure(){}
        public static final CureBlack black = GirlsLoader.get("cure_black");
        public static final CureWhite white = GirlsLoader.get("cure_white");

        public static final CureBloom bloom = GirlsLoader.get("cure_bloom");
        public static final CureEgret egret = GirlsLoader.get("cure_egret");
        public static final CureBright bright = GirlsLoader.get("cure_bright");
        public static final CureWindy windy = GirlsLoader.get("cure_windy");

        public static final CureBlossom blossom = GirlsLoader.get("cure_blossom");
        public static final CureMarine marine = GirlsLoader.get("cure_marine");
        public static final CureSunshine sunshine = GirlsLoader.get("cure_sunshine");
        public static final CureMoonlight moonlight = GirlsLoader.get("cure_moonlight");

        public static final CureMiracle miracle = GirlsLoader.get("cure_miracle");
        public static final CureMagical magical = GirlsLoader.get("cure_magical");
    }

    public static final class Shiny {
        private Shiny(){}
        public static final ShinyLuminous luminous = GirlsLoader.get("shiny_luminous");
    }

    public static final class Milky {
        private Milky(){}
        public static final MilkyRose rose = GirlsLoader.get("milky_rose");
    }
}
