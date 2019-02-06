package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureRhythmTest extends GirlTestBase {

    CureRhythm rhythm = Cure.rhythm;

    @Test
    void 基本情報(){
        assertEquals("cure_rhythm", rhythm.girlName());
        assertEquals("南野奏", rhythm.humanName());
        assertEquals("南野奏", rhythm.fullName());
        assertEquals("Undefined.", rhythm.humanFullName());
        assertEquals("キュアリズム", rhythm.precureName());
        assertEquals("折笠富美子", rhythm.castName());
        assertEquals(LocalDate.of(2011, 2, 6), rhythm.createdDate());
        assertEquals(PrecureColor.WHITE, rhythm.color());
        assertFalse(rhythm.hasBirthday());
        assertEquals("レッツプレイ！プリキュアモジュレーション！！\n" +
                "爪弾くはたおやかな調べ！ キュアリズム！\n" +
                "届け4人の組曲！スイートプリキュア！",
                rhythm.getTransformMessage());
        assertEquals(List.of("クレッシェンドリズム"), rhythm.getExtraNames());
        assertEquals(2, rhythm.getAttackMessages().size());
        assertEquals("おいで、ファリー！\n" +
                "翔けめぐれ、トーンのリング！\n" +
                "プリキュア！ミュージックロンド！\n" +
                "三拍子！１、２、３\n" +
                "フィナーレ！",
                rhythm.getAttackMessages().get(0));
        assertEquals("届けましょう、希望のシンフォニー！\n" +
                "プリキュア！スイートセッションアンサンブル！\n" +
                "クレッシェンド！！\n" +
                "フィナーレ！",
                rhythm.getAttackMessages().get(1));
        assertEquals(List.of("lets_play_precure_modulation",
                            "lets_play",
                            "modulation"),
                            rhythm.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(rhythm, Girl.byName("rhythm"));
    }

    @Test
    void 変身(){
        rhythm.humanize();

        assertEquals("南野奏", rhythm.name());
        rhythm.transform();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くはたおやかな調べ！ キュアリズム！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアリズム", rhythm.name());

        messageTester.messages.clear();
        rhythm.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("クレッシェンドリズム", rhythm.name());

        messageTester.messages.clear();
        rhythm.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("南野奏", rhythm.name());

        messageTester.messages.clear();
        rhythm.letsPlayPrecureModulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くはたおやかな調べ！ キュアリズム！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアリズム", rhythm.name());

        messageTester.messages.clear();
        rhythm.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("南野奏", rhythm.name());

        messageTester.messages.clear();
        rhythm.letsPlay();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くはたおやかな調べ！ キュアリズム！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアリズム", rhythm.name());

        messageTester.messages.clear();
        rhythm.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("南野奏", rhythm.name());

        messageTester.messages.clear();
        rhythm.modulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くはたおやかな調べ！ キュアリズム！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアリズム", rhythm.name());

        messageTester.messages.clear();
        rhythm.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("南野奏", rhythm.name());
    }

    @Test
    void 攻撃(){
        rhythm.humanize();
        assertThrows(RequireTransformException.class, () -> rhythm.attack(), "Require transform.");

        rhythm.transform();
        messageTester.messages.clear();
        rhythm.attack();
        assertEquals(List.of("おいで、ファリー！",
                "翔けめぐれ、トーンのリング！",
                "プリキュア！ミュージックロンド！",
                "三拍子！１、２、３",
                "フィナーレ！"),
                messageTester.messages);

        rhythm.transform();
        messageTester.messages.clear();
        rhythm.attack();
        assertEquals(List.of("届けましょう、希望のシンフォニー！",
                "プリキュア！スイートセッションアンサンブル！",
                "クレッシェンド！！",
                "フィナーレ！"),
                messageTester.messages);
    }
}
