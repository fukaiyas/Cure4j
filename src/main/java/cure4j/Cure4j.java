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

        public static final CureDream dream = GirlsLoader.get("cure_dream");
        public static final CureRouge rouge = GirlsLoader.get("cure_rouge");
        public static final CureLemonade lemonade = GirlsLoader.get("cure_lemonade");
        public static final CureMint mint = GirlsLoader.get("cure_mint");
        public static final CureAqua aqua = GirlsLoader.get("cure_aqua");

        public static final CurePeach peach = GirlsLoader.get("cure_peach");
        public static final CureBerry berry = GirlsLoader.get("cure_berry");
        public static final CurePine pine = GirlsLoader.get("cure_pine");
        public static final CurePassion passion = GirlsLoader.get("cure_passion");

        public static final CureBlossom blossom = GirlsLoader.get("cure_blossom");
        public static final CureMarine marine = GirlsLoader.get("cure_marine");
        public static final CureSunshine sunshine = GirlsLoader.get("cure_sunshine");
        public static final CureMoonlight moonlight = GirlsLoader.get("cure_moonlight");

        public static final CureMelody melody = GirlsLoader.get("cure_melody");
        public static final CureRhythm rhythm = GirlsLoader.get("cure_rhythm");
        public static final CureBeat beat = GirlsLoader.get("cure_beat");
        public static final CureMuse muse = GirlsLoader.get("cure_muse");

        public static final CureHappy happy = GirlsLoader.get("cure_happy");
        public static final CureSunny sunny = GirlsLoader.get("cure_sunny");
        public static final CurePeace peace = GirlsLoader.get("cure_peace");
        public static final CureMarch march = GirlsLoader.get("cure_march");
        public static final CureBeauty beauty = GirlsLoader.get("cure_beauty");

        public static final CureHeart heart = GirlsLoader.get("cure_heart");
        public static final CureDiamond diamond = GirlsLoader.get("cure_diamond");
        public static final CureRosetta rosetta = GirlsLoader.get("cure_rosetta");
        public static final CureSword sword = GirlsLoader.get("cure_sword");
        public static final CureAce ace = GirlsLoader.get("cure_ace");

        public static final CureLovely lovely = GirlsLoader.get("cure_lovely");
        public static final CurePrincess princess = GirlsLoader.get("cure_princess");
        public static final CureHoney honey = GirlsLoader.get("cure_honey");
        public static final CureFortune fortune = GirlsLoader.get("cure_fortune");

        public static final CureFlora flora = GirlsLoader.get("cure_flora");
        public static final CureMermaid mermaid = GirlsLoader.get("cure_mermaid");
        public static final CureTwinkle twinkle = GirlsLoader.get("cure_twinkle");
        public static final CureScarlet scarlet = GirlsLoader.get("cure_scarlet");

        public static final CureMiracle miracle = GirlsLoader.get("cure_miracle");
        public static final CureMagical magical = GirlsLoader.get("cure_magical");
        public static final CureFelice felice = GirlsLoader.get("cure_felice");
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
