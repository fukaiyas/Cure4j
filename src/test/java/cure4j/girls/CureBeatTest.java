package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureBeatTest extends GirlTestBase {

    CureBeat beat = Cure.beat;

    @Test
    void 基本情報(){
        assertEquals("cure_beat", beat.girlName());
        assertEquals("黒川エレン", beat.humanName());
        assertEquals("黒川エレン", beat.fullName());
        assertEquals("Undefined.", beat.humanFullName());
        assertEquals("キュアビート", beat.precureName());
        assertEquals("豊口めぐみ", beat.castName());
        assertEquals(LocalDate.of(2011, 7, 10), beat.createdDate());
        assertEquals(PrecureColor.BLUE, beat.color());
        assertFalse(beat.hasBirthday());
        assertEquals("レッツプレイ！プリキュアモジュレーション！！\n" +
                "爪弾くは魂の調べ！ キュアビート！\n" +
                "届け4人の組曲！スイートプリキュア！",
                beat.getTransformMessage());
        assertEquals(List.of("クレッシェンドビート"), beat.getExtraNames());
        assertEquals(2, beat.getAttackMessages().size());
        assertEquals("翔けめぐれ、トーンのリング！\n" +
                "プリキュア！ハートフルビートロック！\n" +
                "三拍子！１、２、３\n" +
                "フィナーレ！",
                beat.getAttackMessages().get(0));
        assertEquals("届けましょう、希望のシンフォニー！\n" +
                "プリキュア！スイートセッションアンサンブル！\n" +
                "クレッシェンド！！\n" +
                "フィナーレ！",
                beat.getAttackMessages().get(1));
        assertEquals(List.of("lets_play_precure_modulation",
                            "lets_play",
                            "modulation"),
                            beat.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(beat, Girl.byName("beat"));
    }

    @Test
    void 変身(){
        beat.humanize();

        assertEquals("黒川エレン", beat.name());
        beat.transform();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは魂の調べ！ キュアビート！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアビート", beat.name());

        messageTester.messages.clear();
        beat.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("クレッシェンドビート", beat.name());

        messageTester.messages.clear();
        beat.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("黒川エレン", beat.name());

        messageTester.messages.clear();
        beat.letsPlayPrecureModulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは魂の調べ！ キュアビート！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアビート", beat.name());

        messageTester.messages.clear();
        beat.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("黒川エレン", beat.name());

        messageTester.messages.clear();
        beat.letsPlay();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは魂の調べ！ キュアビート！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアビート", beat.name());

        messageTester.messages.clear();
        beat.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("黒川エレン", beat.name());

        messageTester.messages.clear();
        beat.modulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは魂の調べ！ キュアビート！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアビート", beat.name());

        messageTester.messages.clear();
        beat.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("黒川エレン", beat.name());
    }

    @Test
    void 攻撃(){
        beat.humanize();
        assertThrows(RequireTransformException.class, () -> beat.attack(), "Require transform.");

        beat.transform();
        messageTester.messages.clear();
        beat.attack();
        assertEquals(List.of("翔けめぐれ、トーンのリング！",
                "プリキュア！ハートフルビートロック！",
                "三拍子！１、２、３",
                "フィナーレ！"),
                messageTester.messages);

        beat.transform();
        messageTester.messages.clear();
        beat.attack();
        assertEquals(List.of("届けましょう、希望のシンフォニー！",
                "プリキュア！スイートセッションアンサンブル！",
                "クレッシェンド！！",
                "フィナーレ！"),
                messageTester.messages);
    }
}
