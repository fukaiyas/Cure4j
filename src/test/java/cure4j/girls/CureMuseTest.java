package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureMuseTest extends GirlTestBase {

    CureMuse muse = Cure.muse;

    @Test
    void 基本情報(){
        assertEquals("cure_muse", muse.girlName());
        assertEquals("調辺アコ", muse.humanName());
        assertEquals("調辺アコ", muse.fullName());
        assertEquals("Undefined.", muse.humanFullName());
        assertEquals("キュアミューズ", muse.precureName());
        assertEquals("大久保瑠美", muse.castName());
        assertEquals(LocalDate.of(2011, 10, 16), muse.createdDate());
        assertEquals(PrecureColor.YELLOW, muse.color());
        assertFalse(muse.hasBirthday());
        assertEquals("レッツプレイ！プリキュアモジュレーション！！\n" +
                "爪弾くは女神の調べ！ キュアミューズ！\n" +
                "届け4人の組曲！スイートプリキュア！",
                muse.getTransformMessage());
        assertEquals(List.of("クレッシェンドミューズ"), muse.getExtraNames());
        assertEquals(2, muse.getAttackMessages().size());
        assertEquals("おいで、シリー！\n" +
                "シの音符の、シャイニングメロディ！\n" +
                "プリキュア！スパークリングシャワー！！\n" +
                "三拍子！１、２、３\n" +
                "フィナーレ！",
                muse.getAttackMessages().get(0));
        assertEquals("届けましょう、希望のシンフォニー！\n" +
                "プリキュア！スイートセッションアンサンブル！\n" +
                "クレッシェンド！！\n" +
                "フィナーレ！",
                muse.getAttackMessages().get(1));
        assertEquals(List.of("lets_play_precure_modulation",
                            "lets_play",
                            "modulation"),
                            muse.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(muse, Girl.byName("muse"));
    }

    @Test
    void 変身(){
        muse.humanize();

        assertEquals("調辺アコ", muse.name());
        muse.transform();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは女神の調べ！ キュアミューズ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアミューズ", muse.name());

        messageTester.messages.clear();
        muse.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("クレッシェンドミューズ", muse.name());

        messageTester.messages.clear();
        muse.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("調辺アコ", muse.name());

        messageTester.messages.clear();
        muse.letsPlayPrecureModulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは女神の調べ！ キュアミューズ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアミューズ", muse.name());

        messageTester.messages.clear();
        muse.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("調辺アコ", muse.name());

        messageTester.messages.clear();
        muse.letsPlay();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは女神の調べ！ キュアミューズ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアミューズ", muse.name());

        messageTester.messages.clear();
        muse.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("調辺アコ", muse.name());

        messageTester.messages.clear();
        muse.modulation();
        assertEquals(List.of("レッツプレイ！プリキュアモジュレーション！！",
                "爪弾くは女神の調べ！ キュアミューズ！",
                "届け4人の組曲！スイートプリキュア！"),
                messageTester.messages);
        assertEquals("キュアミューズ", muse.name());

        messageTester.messages.clear();
        muse.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("調辺アコ", muse.name());
    }

    @Test
    void 攻撃(){
        muse.humanize();
        assertThrows(RequireTransformException.class, () -> muse.attack(), "Require transform.");

        muse.transform();
        messageTester.messages.clear();
        muse.attack();
        assertEquals(List.of("おいで、シリー！",
                "シの音符の、シャイニングメロディ！",
                "プリキュア！スパークリングシャワー！！",
                "三拍子！１、２、３",
                "フィナーレ！"),
                messageTester.messages);

        muse.transform();
        messageTester.messages.clear();
        muse.attack();
        assertEquals(List.of("届けましょう、希望のシンフォニー！",
                "プリキュア！スイートセッションアンサンブル！",
                "クレッシェンド！！",
                "フィナーレ！"),
                messageTester.messages);
    }
}
