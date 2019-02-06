package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureMelodyTest extends GirlTestBase {

    CureMelody melody = Cure.melody;

    @Test
    void 基本情報(){
        assertEquals("cure_melody", melody.girlName());
        assertEquals("北条響", melody.humanName());
        assertEquals("北条響", melody.fullName());
        assertEquals("Undefined.", melody.humanFullName());
        assertEquals("キュアメロディ", melody.precureName());
        assertEquals("小清水亜美", melody.castName());
        assertEquals(LocalDate.of(2011, 2, 6), melody.createdDate());
        assertEquals(PrecureColor.PINK, melody.color());
        assertFalse(melody.hasBirthday());
        assertEquals("レッツプレイ！プリキュアモジュレーション！！\n" +
                "爪弾くは荒ぶる調べ！ キュアメロディ！\n" +
                "届け4人の組曲！スイートプリキュア！",
                melody.getTransformMessage());
        assertEquals(List.of("クレッシェンドメロディ"), melody.getExtraNames());
        assertEquals(2, melody.getAttackMessages().size());
        assertEquals("おいで、ミリー！\n" +
                "翔けめぐれ、トーンのリング！\n" +
                "プリキュア！ミュージックロンド！\n" +
                "三拍子！１、２、３\n" +
                "フィナーレ！",
                melody.getAttackMessages().get(0));
        assertEquals("届けましょう、希望のシンフォニー！\n" +
                "プリキュア！スイートセッションアンサンブル！\n" +
                "クレッシェンド！！\n" +
                "フィナーレ！",
                melody.getAttackMessages().get(1));
        assertEquals(List.of("lets_play_precure_modulation",
                            "lets_play",
                            "modulation"),
                            melody.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(melody, Girl.byName("melody"));
    }

    @Test
    void 変身(){
        melody.humanize();

        assertEquals("北条響", melody.name());
        melody.transform();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは荒ぶる調べ！ キュアメロディ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアメロディ", melody.name());

        messageTester.messages.clear();
        melody.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("クレッシェンドメロディ", melody.name());

        messageTester.messages.clear();
        melody.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("北条響", melody.name());

        messageTester.messages.clear();
        melody.letsPlayPrecureModulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは荒ぶる調べ！ キュアメロディ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアメロディ", melody.name());

        messageTester.messages.clear();
        melody.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("北条響", melody.name());

        messageTester.messages.clear();
        melody.letsPlay();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは荒ぶる調べ！ キュアメロディ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアメロディ", melody.name());

        messageTester.messages.clear();
        melody.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("北条響", melody.name());

        messageTester.messages.clear();
        melody.modulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは荒ぶる調べ！ キュアメロディ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアメロディ", melody.name());

        messageTester.messages.clear();
        melody.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("北条響", melody.name());
    }

    @Test
    void 攻撃(){
        melody.humanize();
        assertThrows(RequireTransformException.class, () -> melody.attack(), "Require transform.");

        melody.transform();
        messageTester.messages.clear();
        melody.attack();
        assertEquals(List.of("おいで、ミリー！",
                "翔けめぐれ、トーンのリング！",
                "プリキュア！ミュージックロンド！",
                "三拍子！１、２、３",
                "フィナーレ！"),
                messageTester.messages);

        melody.transform();
        messageTester.messages.clear();
        melody.attack();
        assertEquals(List.of("届けましょう、希望のシンフォニー！",
                "プリキュア！スイートセッションアンサンブル！",
                "クレッシェンド！！",
                "フィナーレ！"),
                messageTester.messages);
    }
}
