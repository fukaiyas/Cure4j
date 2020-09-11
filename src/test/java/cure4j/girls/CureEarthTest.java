package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureEarthTest extends GirlTestBase {

    CureEarth earth = Cure.earth;

    @Test
    void 基本情報(){
        assertEquals("cure_earth", earth.girlName());
        assertEquals("風鈴アスミ", earth.humanName());
        assertEquals("風鈴アスミ", earth.fullName());
        assertEquals("Undefined.", earth.humanFullName());
        assertEquals("キュアアース", earth.precureName());
        assertEquals("三森すずこ", earth.castName());
        assertEquals(LocalDate.of(2020, 8, 9), earth.createdDate());
        assertEquals(PrecureColor.PURPLE, earth.color());
        assertTrue(earth.hasBirthday());
        assertEquals("8/16", earth.birthday());
        assertEquals("スタート！\n" +
                "プリキュアオペレーション！\n" +
                "エレメントレベル上昇ラテ！\n" +
                "キュアタッチ！\n" +
                "キュン！\n" +
                "キュン！\n" +
                "時を経てつながる二つの風、キュアアース！\n" +
                "ワン！\n" +
                "地球をお手当！ヒーリングっど♥プリキュア！",
                earth.getTransformMessage());
        assertEquals(0, earth.getExtraNames().size());
        assertEquals(1, earth.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "アースウィンディハープ！\n" +
                "エレメントチャージ！\n" +
                "舞い上がれ、癒やしの風！\n" +
                "プリキュア・ヒーリングハリケーン！\n" +
                "お大事に"),
                earth.getAttackMessages().get(0));
        assertEquals(List.of("precure_operation"),
                            earth.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(earth, Girl.byName("earth"));
    }

    @Test
    void 変身(){
        earth.humanize();

        assertEquals("風鈴アスミ", earth.name());
        earth.transform();
        assertEquals(List.of("スタート！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ラテ！",
                "キュアタッチ！",
                "キュン！",
                "キュン！",
                "時を経てつながる二つの風、キュアアース！",
                "ワン！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアアース", earth.name());

        messageTester.messages.clear();
        earth.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("風鈴アスミ", earth.name());

        messageTester.messages.clear();
        earth.operation();
        assertEquals(List.of("スタート！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ラテ！",
                "キュアタッチ！",
                "キュン！",
                "キュン！",
                "時を経てつながる二つの風、キュアアース！",
                "ワン！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアアース", earth.name());

        messageTester.messages.clear();
        earth.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("風鈴アスミ", earth.name());
    }

    @Test
    void 攻撃(){
        earth.humanize();
        assertThrows(RequireTransformException.class, () -> earth.attack(), "Require transform.");

        earth.transform();
        messageTester.messages.clear();
        earth.attack();
        assertEquals(List.of("アースウィンディハープ！",
                "エレメントチャージ！",
                "舞い上がれ、癒やしの風！",
                "プリキュア・ヒーリングハリケーン！",
                "お大事に"),
                messageTester.messages);
    }
}
