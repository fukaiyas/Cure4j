package cure4j.internal;

import cure4j.girls.*;
import cure4j.util.Listream;

import java.util.*;
import java.util.stream.Collectors;

public class GirlsLoader {

    private static final Map<String, Class<? extends Girl<?>>> GIRL_CLASSES = Map.ofEntries(
            entry("cure_black", CureBlack.class),
            entry("cure_white", CureWhite.class),
            entry("shiny_luminous", ShinyLuminous.class),

            entry("cure_bloom", CureBloom.class),
            entry("cure_egret", CureEgret.class),
            entry("cure_bright", CureBright.class),
            entry("cure_windy", CureWindy.class),

            entry("cure_dream", CureDream.class),
            entry("cure_rouge", CureRouge.class),
            entry("cure_lemonade", CureLemonade.class),
            entry("cure_mint", CureMint.class),
            entry("cure_aqua", CureAqua.class),
            entry("milky_rose", MilkyRose.class),

            entry("cure_peach", CurePeach.class),
            entry("cure_berry", CureBerry.class),
            entry("cure_pine", CurePine.class),
            entry("cure_passion", CurePassion.class),

            entry("cure_blossom", CureBlossom.class),
            entry("cure_marine", CureMarine.class),
            entry("cure_sunshine", CureSunshine.class),
            entry("cure_moonlight", CureMoonlight.class),

            entry("cure_melody", CureMelody.class),
            entry("cure_rhythm", CureRhythm.class),
            entry("cure_beat", CureBeat.class),
            entry("cure_muse", CureMuse.class),

            entry("cure_happy", CureHappy.class),
            entry("cure_sunny", CureSunny.class),
            entry("cure_peace", CurePeace.class),
            entry("cure_march", CureMarch.class),
            entry("cure_beauty", CureBeauty.class),

            entry("cure_heart", CureHeart.class),
            entry("cure_diamond", CureDiamond.class),
            entry("cure_rosetta", CureRosetta.class),
            entry("cure_sword", CureSword.class),
            entry("cure_ace", CureAce.class),

            entry("cure_lovely", CureLovely.class),
            entry("cure_princess", CurePrincess.class),
            entry("cure_honey", CureHoney.class),
            entry("cure_fortune", CureFortune.class),

            entry("cure_flora", CureFlora.class),
            entry("cure_mermaid", CureMermaid.class),
            entry("cure_twinkle", CureTwinkle.class),
            entry("cure_scarlet", CureScarlet.class),

            entry("cure_miracle", CureMiracle.class),
            entry("cure_magical", CureMagical.class),
            entry("cure_felice", CureFelice.class),

            entry("cure_whip", CureWhip.class),
            entry("cure_custard", CureCustard.class),
            entry("cure_gelato", CureGelato.class),
            entry("cure_macaron", CureMacaron.class),
            entry("cure_chocolat", CureChocolat.class),
            entry("cure_parfait", CureParfait.class),

            entry("cure_yell", CureYell.class),
            entry("cure_ange", CureAnge.class),
            entry("cure_etoile", CureEtoile.class),
            entry("cure_macherie", CureMacherie.class),
            entry("cure_amour", CureAmour.class),

            entry("cure_star", CureStar.class),
            entry("cure_milky", CureMilky.class),
            entry("cure_soleil", CureSoleil.class),
            entry("cure_selene", CureSelene.class),
            entry("cure_cosmo", CureCosmo.class),

            entry("cure_grace", CureGrace.class),
            entry("cure_fontaine", CureFontaine.class),
            entry("cure_sparkle", CureSparkle.class),
            entry("cure_earth", CureEarth.class),

            entry("cure_summer", CureSummer.class),
            entry("cure_coral", CureCoral.class),
            entry("cure_papaya", CurePapaya.class),
            entry("cure_flamingo", CureFlamingo.class),
            entry("cure_lamer", CureLamer.class),

            entry("cure_precious", CurePrecious.class),
            entry("cure_spicy", CureSpicy.class),
            entry("cure_yumyum", CureYumyum.class),
            entry("cure_finale", CureFinale.class),

            entry("cure_sky", CureSky.class),
            entry("cure_prism", CurePrism.class),
            entry("cure_wing", CureWing.class),
            entry("cure_butterfly", CureButterfly.class),
            entry("cure_majesty", CureMajesty.class),

            entry("cure_wonderful", CureWonderful.class),
            entry("cure_friendy", CureFriendy.class),
            entry("cure_nyammy", CureNyammy.class),
            entry("cure_lillian", CureLillian.class),

            entry("cure_echo", CureEcho.class)
    );
    private static Map.Entry<String, Class<? extends Girl<?>>>
            entry(String girlName, Class<? extends Girl<?>> girlClass){
        try {
            return new AbstractMap.SimpleImmutableEntry<>(girlName, girlClass);
        }catch (Throwable t){
            t.printStackTrace();
            throw  t;
        }
    }

    private static final List<String> FILES = List.of(
            "/girls/001_unmarked.yml",
            "/girls/002_max_heart.yml",
            "/girls/003_splash_star.yml",
            "/girls/004_yes.yml",
            "/girls/005_yes_gogo.yml",
            "/girls/006_fresh.yml",
            "/girls/007_heart_catch.yml",
            "/girls/008_suite.yml",
            "/girls/009_smile.yml",
            "/girls/010_dokidoki.yml",
            "/girls/011_happiness_charge.yml",
            "/girls/012_go_princess.yml",
            "/girls/013_maho_girls.yml",
            "/girls/014_a_la_mode.yml",
            "/girls/015_hugtto.yml",
            "/girls/016_star_twinkle.yml",
            "/girls/017_healingood.yml",
            "/girls/018_tropical_rouge.yml",
            "/girls/019_delicious_party.yml",
            "/girls/020_hirogaru_sky.yml",
            "/girls/021_wonderful.yml",
            "/girls/movie.yml"
    );

    private static final Map<String, Girl<?>> GIRL_INSTANCE = load();

    public static Listream<Girl<?>> getAllGirls(){
        return new Listream<Girl<?>>(
                GIRL_INSTANCE.values().stream()
                        .sorted(Comparator.comparing(Girl::createdDate)) //TODO 本当は同じ日に登場したキャラクターにも順序をつけたい
                        .distinct()
                        .collect(Collectors.toList()));
    }
    @SuppressWarnings("unchecked")
    public static <T extends Girl<?>> T get(String girlName){
        if(!GIRL_INSTANCE.containsKey(girlName)){
            throw new UnknownGirlException("Unknown girl name : " + girlName);
        }
        return (T)GIRL_INSTANCE.get(girlName);
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Girl<?>> load(){
        Map<String, Girl<?>> result = new HashMap<>();
        for(String path : FILES) {
            result.putAll(LoaderUtil.loadYaml(
                    path,
                    root -> root.entrySet().stream()
                            .filter(es -> GIRL_CLASSES.containsKey(es.getKey()))
                            .collect(Collectors.toMap(
                                    es -> es.getKey(),
                                    es -> create(GIRL_CLASSES.get(es.getKey()), es.getValue())
                            )))
            );
            result.putAll(LoaderUtil.loadYaml(
                    path,
                    root -> root.entrySet().stream()
                            .filter(es -> !GIRL_CLASSES.containsKey(es.getKey()))
                            .collect(Collectors.toMap(
                                    es -> es.getKey(),
                                    es -> result.get((String) ((Map<String, Object>)es.getValue()).get("girl_name"))
                            )))
            );
        }
        return result;
    }
    private static Girl<? extends Girl<?>> create(Class<? extends Girl<?>> girlClass, Object config){
        try {
            return girlClass.getConstructor(Map.class).newInstance(config);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
