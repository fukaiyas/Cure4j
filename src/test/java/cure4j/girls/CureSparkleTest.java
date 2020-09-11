package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureSparkleTest extends GirlTestBase {

    CureSparkle sparkle = Cure.sparkle;

    @Test
    void 基本情報(){
        assertEquals("cure_sparkle", sparkle.girlName());
        assertEquals("平光ひなた", sparkle.humanName());
        assertEquals("平光ひなた", sparkle.fullName());
        assertEquals("Undefined.", sparkle.humanFullName());
        assertEquals("キュアスパークル", sparkle.precureName());
        assertEquals("河野ひより", sparkle.castName());
        assertEquals(LocalDate.of(2020, 2, 23), sparkle.createdDate());
        assertEquals(PrecureColor.YELLOW, sparkle.color());
        assertTrue(sparkle.hasBirthday());
        assertEquals("10/4", sparkle.birthday());
        assertEquals("スタート！\n" +
                "プリキュアオペレーション！\n" +
                "エレメントレベル上昇ニャ！\n" +
                "キュアタッチ！\n" +
                "キュン！\n" +
                "キュン！\n" +
                "溶け合う二つの光、キュアスパークル！\n" +
                "ニャ！\n" +
                "地球をお手当！ヒーリングっど♥プリキュア！",
                sparkle.getTransformMessage());
        assertEquals(0, sparkle.getExtraNames().size());
        assertEquals(1, sparkle.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "エレメントチャージ！\n" +
                "キュン！キュン！キュン！\n" +
                "ヒーリングゲージ上昇！\n" +
                "プリキュア！ヒーリングフラッシュ！\n" +
                "お大事に"),
                sparkle.getAttackMessages().get(0));
        assertEquals(List.of("precure_operation"),
                            sparkle.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(sparkle, Girl.byName("sparkle"));
    }

    @Test
    void 変身(){
        sparkle.humanize();

        assertEquals("平光ひなた", sparkle.name());
        sparkle.transform();
        assertEquals(List.of("スタート！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ニャ！",
                "キュアタッチ！",
                "キュン！",
                "キュン！",
                "溶け合う二つの光、キュアスパークル！",
                "ニャ！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアスパークル", sparkle.name());

        messageTester.messages.clear();
        sparkle.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("平光ひなた", sparkle.name());

        messageTester.messages.clear();
        sparkle.operation();
        assertEquals(List.of("スタート！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ニャ！",
                "キュアタッチ！",
                "キュン！",
                "キュン！",
                "溶け合う二つの光、キュアスパークル！",
                "ニャ！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアスパークル", sparkle.name());

        messageTester.messages.clear();
        sparkle.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("平光ひなた", sparkle.name());
    }

    @Test
    void 攻撃(){
        sparkle.humanize();
        assertThrows(RequireTransformException.class, () -> sparkle.attack(), "Require transform.");

        sparkle.transform();
        messageTester.messages.clear();
        sparkle.attack();
        assertEquals(List.of("エレメントチャージ！",
                "キュン！キュン！キュン！",
                "ヒーリングゲージ上昇！",
                "プリキュア！ヒーリングフラッシュ！",
                "お大事に"),
                messageTester.messages);
    }
}
