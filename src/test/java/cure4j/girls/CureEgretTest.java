package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureEgretTest extends GirlTestBase {

    CureEgret egret = Cure.egret;

    @Test
    void 基本情報(){
        assertEquals("cure_egret", egret.girlName());
        assertEquals("美翔舞", egret.humanName());
        assertEquals("美翔舞", egret.fullName());
        assertEquals("Undefined.", egret.humanFullName());
        assertEquals("キュアイーグレット", egret.precureName());
        assertEquals("榎本温子", egret.castName());
        assertEquals(LocalDate.of(2006, 2, 5), egret.createdDate());
        assertEquals(PrecureColor.WHITE, egret.color());
        assertTrue(egret.hasBirthday());
        assertEquals("11/20", egret.birthday());
        assertEquals("デュアル・スピリチュアル・パワー！\n" +
                        "羽ばたけ空に！\n" +
                        "煌めく銀の翼！ キュアイーグレット！\n" +
                        "ふたりはプリキュア！\n" +
                        "聖なる泉を汚す者よ！\n" +
                        "阿漕な真似はお止めなさい！",
                egret.getTransformMessage());
        assertEquals(0, egret.getExtraNames().size());
        assertEquals(1, egret.getAttackMessages().size());
        assertEquals("大地の精霊よ\n" +
                        "大空の精霊よ\n" +
                        "今、プリキュアと共に！\n" +
                        "奇跡の力を解き放て！\n" +
                        "プリキュア　ツインストリーム・スプラッシュ！！",
                egret.getAttackMessages().get(0));
        assertEquals(List.of("dual_spiritual_power"), egret.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(egret, Girl.byName("egret"));
    }

    @Test
    void 変身(){
        egret.humanize();

        assertEquals("美翔舞", egret.name());
        egret.transform();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "羽ばたけ空に！",
                        "煌めく銀の翼！ キュアイーグレット！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアイーグレット", egret.name());

        messageTester.messages.clear();
        egret.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美翔舞", egret.name());

        messageTester.messages.clear();
        egret.dualSpiritualPower();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "羽ばたけ空に！",
                        "煌めく銀の翼！ キュアイーグレット！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアイーグレット", egret.name());

        messageTester.messages.clear();
        egret.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美翔舞", egret.name());
    }

    @Test
    void 攻撃(){
        egret.humanize();
        assertThrows(RequireTransformException.class, () -> egret.attack(), "Require transform.");

        egret.transform();
        messageTester.messages.clear();
        egret.attack();
        assertEquals(List.of("大地の精霊よ",
                        "大空の精霊よ",
                        "今、プリキュアと共に！",
                        "奇跡の力を解き放て！",
                        "プリキュア　ツインストリーム・スプラッシュ！！"),
                messageTester.messages);
    }
}
