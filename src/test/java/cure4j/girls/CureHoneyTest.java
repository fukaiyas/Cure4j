package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureHoneyTest extends GirlTestBase {

    CureHoney honey = Cure.honey;

    @Test
    void 基本情報(){
        assertEquals("cure_honey", honey.girlName());
        assertEquals("大森ゆうこ", honey.humanName());
        assertEquals("大森ゆうこ", honey.fullName());
        assertEquals("Undefined.", honey.humanFullName());
        assertEquals("キュアハニー", honey.precureName());
        assertEquals("北川里奈", honey.castName());
        assertEquals(LocalDate.of(2014, 3, 15), honey.createdDate());
        assertEquals(PrecureColor.YELLOW, honey.color());
        assertFalse(honey.hasBirthday());
        assertEquals("(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！\n" +
                "大地に実る命の光！キュアハニー！\n" +
                "ハピネス注入！幸せチャージ！\n" +
                "ハピネスチャージプリキュア！",
                honey.getTransformMessage());
        assertEquals(List.of("キュアハニー ポップコーンチア",
                "キュアハニー ココナッツサンバ"),
                honey.getExtraNames());
        assertEquals(3, honey.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "命の光を聖なる力へ！\n" +
                "ハニーバトン！\n" +
                "プリキュア！スパークリングバトンアタック！！\n" +
                "イエイ！\n" +
                "命よ、天に帰れ！\n" +
                TestUtil.waveDash2FullwidthTilde("(ゴクラ〜ク…)")),
                honey.getAttackMessages().get(0));
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！ポップコーンチア！！\n" +
                "プリキュア！リボンハートエクスプロージョン！！\n" +
                "ビクトリー！！"),
                honey.getAttackMessages().get(1));
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！ココナッツサンバ！！\n" +
                "プリキュア！マラカスリズムスパーク！！\n" +
                "マンボ！！"),
                honey.getAttackMessages().get(2));
        assertEquals(List.of("kururin_mirror_change"),
                            honey.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(honey, Girl.byName("honey"));
    }

    @Test
    void 変身(){
        honey.humanize();

        assertEquals("大森ゆうこ", honey.name());
        honey.transform();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！",
                "大地に実る命の光！キュアハニー！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアハニー", honey.name());

        messageTester.messages.clear();
        honey.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアハニー ポップコーンチア", honey.name());

        messageTester.messages.clear();
        honey.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアハニー ココナッツサンバ", honey.name());

        messageTester.messages.clear();
        honey.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("大森ゆうこ", honey.name());

        messageTester.messages.clear();
        honey.kururinMirrorChange();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！",
                "大地に実る命の光！キュアハニー！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアハニー", honey.name());

        messageTester.messages.clear();
        honey.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("大森ゆうこ", honey.name());
    }

    @Test
    void 攻撃(){
        honey.humanize();
        assertThrows(RequireTransformException.class, () -> honey.attack(), "Require transform.");

        honey.transform();
        messageTester.messages.clear();
        honey.attack();
        assertEquals(List.of("命の光を聖なる力へ！",
                "ハニーバトン！",
                "プリキュア！スパークリングバトンアタック！！",
                "イエイ！",
                "命よ、天に帰れ！",
                TestUtil.waveDash2FullwidthTilde("(ゴクラ〜ク…)")),
                messageTester.messages);

        honey.transform();
        messageTester.messages.clear();
        honey.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！ポップコーンチア！！",
                "プリキュア！リボンハートエクスプロージョン！！",
                "ビクトリー！！"),
                messageTester.messages);

        honey.transform();
        messageTester.messages.clear();
        honey.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！ココナッツサンバ！！",
                "プリキュア！マラカスリズムスパーク！！",
                "マンボ！！"),
                messageTester.messages);
    }
}
