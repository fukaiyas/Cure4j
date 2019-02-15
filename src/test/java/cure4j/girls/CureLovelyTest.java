package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureLovelyTest extends GirlTestBase {

    CureLovely lovely = Cure.lovely;

    @Test
    void 基本情報(){
        assertEquals("cure_lovely", lovely.girlName());
        assertEquals("愛乃めぐみ", lovely.humanName());
        assertEquals("愛乃めぐみ", lovely.fullName());
        assertEquals("Undefined.", lovely.humanFullName());
        assertEquals("キュアラブリー", lovely.precureName());
        assertEquals("中島愛", lovely.castName());
        assertEquals(LocalDate.of(2014, 2, 2), lovely.createdDate());
        assertEquals(PrecureColor.PINK, lovely.color());
        assertFalse(lovely.hasBirthday());
        assertEquals("(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！\n" +
                "世界に広がるビッグな愛！キュアラブリー！\n" +
                "ハピネス注入！幸せチャージ！\n" +
                "ハピネスチャージプリキュア！",
                lovely.getTransformMessage());
        assertEquals(List.of("キュアラブリー チェリーフラメンコ",
                        "キュアラブリー ロリポップヒップポップ",
                        "フォーエバーラブリー"),
                        lovely.getExtraNames());
        assertEquals(4, lovely.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "愛の光を聖なる力に！\n" +
                "ラブプリブレス！\n" +
                "プリキュア！ピンキーラブシュート！！\n" +
                "愛よ、天に帰れ！\n" +
                "(ゴクラ〜ク…)"),
                lovely.getAttackMessages().get(0));
        assertEquals("(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！チェリーフラメンコ！\n" +
                "プリキュア！パッションダイナマイト！！\n" +
                "オーレ！",
                lovely.getAttackMessages().get(1));
        assertEquals("(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！ロリポップヒップポップ！！！\n" +
                "プリキュア！ポップンソニックアタック！！",
                lovely.getAttackMessages().get(2));
        assertEquals("プリキュア！フォーエバーハピネスシャワー！！",
                lovely.getAttackMessages().get(3));
        assertEquals(List.of("kururin_mirror_change"),
                            lovely.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(lovely, Girl.byName("lovely"));
    }

    @Test
    void 変身(){
        lovely.humanize();

        assertEquals("愛乃めぐみ", lovely.name());
        lovely.transform();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！",
                "世界に広がるビッグな愛！キュアラブリー！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアラブリー", lovely.name());

        messageTester.messages.clear();
        lovely.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアラブリー チェリーフラメンコ", lovely.name());

        messageTester.messages.clear();
        lovely.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアラブリー ロリポップヒップポップ", lovely.name());

        messageTester.messages.clear();
        lovely.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("フォーエバーラブリー", lovely.name());

        messageTester.messages.clear();
        lovely.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("愛乃めぐみ", lovely.name());

        messageTester.messages.clear();
        lovely.kururinMirrorChange();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！",
                "世界に広がるビッグな愛！キュアラブリー！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアラブリー", lovely.name());

        messageTester.messages.clear();
        lovely.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("愛乃めぐみ", lovely.name());
    }

    @Test
    void 攻撃(){
        lovely.humanize();
        assertThrows(RequireTransformException.class, () -> lovely.attack(), "Require transform.");

        lovely.transform();
        messageTester.messages.clear();
        lovely.attack();
        assertEquals(List.of("愛の光を聖なる力に！",
                "ラブプリブレス！",
                "プリキュア！ピンキーラブシュート！！",
                "愛よ、天に帰れ！",
                TestUtil.waveDash2FullwidthTilde("(ゴクラ〜ク…)")),
                messageTester.messages);

        lovely.transform();
        messageTester.messages.clear();
        lovely.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！チェリーフラメンコ！",
                "プリキュア！パッションダイナマイト！！",
                "オーレ！"),
                messageTester.messages);

        lovely.transform();
        messageTester.messages.clear();
        lovely.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！ロリポップヒップポップ！！！",
                "プリキュア！ポップンソニックアタック！！"),
                messageTester.messages);

        lovely.transform();
        messageTester.messages.clear();
        lovely.attack();
        assertEquals(List.of("プリキュア！フォーエバーハピネスシャワー！！"),
                messageTester.messages);
    }
}
