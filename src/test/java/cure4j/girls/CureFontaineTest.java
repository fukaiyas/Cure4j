package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureFontaineTest extends GirlTestBase {

    CureFontaine fontaine = Cure.fontaine;

    @Test
    void 基本情報(){
        assertEquals("cure_fontaine", fontaine.girlName());
        assertEquals("沢泉ちゆ", fontaine.humanName());
        assertEquals("沢泉ちゆ", fontaine.fullName());
        assertEquals("Undefined.", fontaine.humanFullName());
        assertEquals("キュアフォンテーヌ", fontaine.precureName());
        assertEquals("依田菜津", fontaine.castName());
        assertEquals(LocalDate.of(2020, 2, 16), fontaine.createdDate());
        assertEquals(PrecureColor.BLUE, fontaine.color());
        assertTrue(fontaine.hasBirthday());
        assertEquals("8/21", fontaine.birthday());
        assertEquals("スタート！\n" +
                "プリキュアオペレーション！\n" +
                "エレメントレベル上昇ペ！\n" +
                "キュアタッチ！\n" +
                "キュ！\n" +
                "キュ！\n" +
                "交わる二つの流れ、キュアフォンテーヌ！\n" +
                "ぺ！\n" +
                "地球をお手当！ヒーリングっど♥プリキュア！",
                fontaine.getTransformMessage());
        assertEquals(0, fontaine.getExtraNames().size());
        assertEquals(1, fontaine.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "エレメントチャージ！\n" +
                "キュ！キュ！キュ！\n" +
                "ヒーリングゲージ上昇！\n" +
                "プリキュア！ヒーリングストリーム！\n" +
                "お大事に"),
                fontaine.getAttackMessages().get(0));
        assertEquals(List.of("precure_operation"),
                            fontaine.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(fontaine, Girl.byName("fontaine"));
    }

    @Test
    void 変身(){
        fontaine.humanize();

        assertEquals("沢泉ちゆ", fontaine.name());
        fontaine.transform();
        assertEquals(List.of("スタート！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ペ！",
                "キュアタッチ！",
                "キュ！",
                "キュ！",
                "交わる二つの流れ、キュアフォンテーヌ！",
                "ぺ！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアフォンテーヌ", fontaine.name());

        messageTester.messages.clear();
        fontaine.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("沢泉ちゆ", fontaine.name());

        messageTester.messages.clear();
        fontaine.operation();
        assertEquals(List.of("スタート！",
                "プリキュアオペレーション！",
                "エレメントレベル上昇ペ！",
                "キュアタッチ！",
                "キュ！",
                "キュ！",
                "交わる二つの流れ、キュアフォンテーヌ！",
                "ぺ！",
                "地球をお手当！ヒーリングっど♥プリキュア！"),
                messageTester.messages);
        assertEquals("キュアフォンテーヌ", fontaine.name());

        messageTester.messages.clear();
        fontaine.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("沢泉ちゆ", fontaine.name());
    }

    @Test
    void 攻撃(){
        fontaine.humanize();
        assertThrows(RequireTransformException.class, () -> fontaine.attack(), "Require transform.");

        fontaine.transform();
        messageTester.messages.clear();
        fontaine.attack();
        assertEquals(List.of("エレメントチャージ！",
                "キュ！キュ！キュ！",
                "ヒーリングゲージ上昇！",
                "プリキュア！ヒーリングストリーム！",
                "お大事に"),
                messageTester.messages);
    }
}
