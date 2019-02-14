package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureFortuneTest extends GirlTestBase {

    CureFortune fortune = Cure.fortune;

    @Test
    void 基本情報(){
        assertEquals("cure_fortune", fortune.girlName());
        assertEquals("氷川いおな", fortune.humanName());
        assertEquals("氷川いおな", fortune.fullName());
        assertEquals("Undefined.", fortune.humanFullName());
        assertEquals("キュアフォーチュン", fortune.precureName());
        assertEquals("戸松遥", fortune.castName());
        assertEquals(LocalDate.of(2014, 6, 29), fortune.createdDate());
        assertEquals(PrecureColor.PURPLE, fortune.color());
        assertFalse(fortune.hasBirthday());
        assertEquals("(かわルンルン！)\n" +
                "プリキュアきらりんスターシンフォニー！\n" +
                "夜空にきらめく希望の星！キュアフォーチュン！\n" +
                "ハピネス注入！幸せチャージ！\n" +
                "ハピネスチャージプリキュア！",
                fortune.getTransformMessage());
        assertEquals(List.of("キュアフォーチュン パインアラビアン",
                "キュアフォーチュン あんみつこまち"),
                fortune.getExtraNames());
        assertEquals(3, fortune.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "星の光を聖なる力に！\n" +
                "フォーチュンタンバリン！\n" +
                "プリキュア！スターライトアセンション！！\n" +
                "星よ、天に帰れ！\n" +
                TestUtil.waveDash2FullwidthTilde("(ゴクラ〜ク…)")),
                fortune.getAttackMessages().get(0));
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "(かわルンルン！)\n" +
                "プリキュアきらりんスターシンフォニー！パインアラビアン！\n" +
                "プリキュア！オリエンタルドリーム！"),
                fortune.getAttackMessages().get(1));
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "(かわルンルン！)\n" +
                "プリキュアきらりんスターシンフォニー！あんみつこまち！\n" +
                "プリキュア！桜吹雪の舞！"),
                fortune.getAttackMessages().get(2));
        assertEquals(List.of("kirarin_star_symphony"),
                            fortune.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(fortune, Girl.byName("fortune"));
    }

    @Test
    void 変身(){
        fortune.humanize();

        assertEquals("氷川いおな", fortune.name());
        fortune.transform();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアきらりんスターシンフォニー！",
                "夜空にきらめく希望の星！キュアフォーチュン！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアフォーチュン", fortune.name());

        messageTester.messages.clear();
        fortune.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアフォーチュン パインアラビアン", fortune.name());

        messageTester.messages.clear();
        fortune.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアフォーチュン あんみつこまち", fortune.name());

        messageTester.messages.clear();
        fortune.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("氷川いおな", fortune.name());

        messageTester.messages.clear();
        fortune.kirarinStarSymphony();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアきらりんスターシンフォニー！",
                "夜空にきらめく希望の星！キュアフォーチュン！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアフォーチュン", fortune.name());

        messageTester.messages.clear();
        fortune.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("氷川いおな", fortune.name());
    }

    @Test
    void 攻撃(){
        fortune.humanize();
        assertThrows(RequireTransformException.class, () -> fortune.attack(), "Require transform.");

        fortune.transform();
        messageTester.messages.clear();
        fortune.attack();
        assertEquals(List.of("星の光を聖なる力に！",
                "フォーチュンタンバリン！",
                "プリキュア！スターライトアセンション！！",
                "星よ、天に帰れ！",
                TestUtil.waveDash2FullwidthTilde("(ゴクラ〜ク…)")),
                messageTester.messages);

        fortune.transform();
        messageTester.messages.clear();
        fortune.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアきらりんスターシンフォニー！パインアラビアン！",
                "プリキュア！オリエンタルドリーム！"),
                messageTester.messages);

        fortune.transform();
        messageTester.messages.clear();
        fortune.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアきらりんスターシンフォニー！あんみつこまち！",
                "プリキュア！桜吹雪の舞！"),
                messageTester.messages);
    }
}
