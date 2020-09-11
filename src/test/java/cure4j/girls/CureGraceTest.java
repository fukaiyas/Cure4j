package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureGraceTest extends GirlTestBase {

    CureGrace grace = Cure.grace;

    @Test
    void 基本情報(){
        assertEquals("cure_grace", grace.girlName());
        assertEquals("花寺のどか", grace.humanName());
        assertEquals("花寺のどか", grace.fullName());
        assertEquals("Undefined.", grace.humanFullName());
        assertEquals("キュアグレース", grace.precureName());
        assertEquals("悠木碧", grace.castName());
        assertEquals(LocalDate.of(2020, 2, 2), grace.createdDate());
        assertEquals(PrecureColor.PINK, grace.color());
        assertTrue(grace.hasBirthday());
        assertEquals("3/9", grace.birthday());
        assertEquals("スタンバイ！\n" +
                "プリキュアオペレーション！\n" +
                "エレメントレベル上昇ラビ！\n" +
                "キュアタッチ！\n" +
                "キュア！\n" +
                "キュア！\n" +
                "重なる二つの花！キュアグレース！\n" +
                "ラビ！\n" +
                "地球をお手当！ヒーリングっど♥プリキュア！",
                grace.getTransformMessage());
        assertEquals(0, grace.getExtraNames().size());
        assertEquals(1, grace.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "エレメントチャージ！\n" +
                "キュア！キュア！キュア！\n" +
                "ヒーリングゲージ上昇！\n" +
                "プリキュア！ヒーリングフラワー！\n" +
                "お大事に"),
                grace.getAttackMessages().get(0));
        assertEquals(List.of("precure_operation"),
                            grace.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(grace, Girl.byName("grace"));
    }

    @Test
    void 変身(){
        grace.humanize();

        assertEquals("花寺のどか", grace.name());
        grace.transform();
        assertEquals(List.of("スタンバイ！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ラビ！",
                "キュアタッチ！",
                "キュア！",
                "キュア！",
                "重なる二つの花！キュアグレース！",
                "ラビ！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアグレース", grace.name());

        messageTester.messages.clear();
        grace.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("花寺のどか", grace.name());

        messageTester.messages.clear();
        grace.operation();
        assertEquals(List.of("スタンバイ！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ラビ！",
                "キュアタッチ！",
                "キュア！",
                "キュア！",
                "重なる二つの花！キュアグレース！",
                "ラビ！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアグレース", grace.name());

        messageTester.messages.clear();
        grace.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("花寺のどか", grace.name());
    }

    @Test
    void 攻撃(){
        grace.humanize();
        assertThrows(RequireTransformException.class, () -> grace.attack(), "Require transform.");

        grace.transform();
        messageTester.messages.clear();
        grace.attack();
        assertEquals(List.of("エレメントチャージ！",
                "キュア！キュア！キュア！",
                "ヒーリングゲージ上昇！",
                "プリキュア！ヒーリングフラワー！",
                "お大事に"),
                messageTester.messages);
    }
}
