package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureBloomTest extends GirlTestBase {

    CureBloom bloom = Cure.bloom;

    @Test
    void 基本情報(){
        assertEquals("cure_bloom", bloom.girlName());
        assertEquals("日向咲", bloom.humanName());
        assertEquals("日向咲", bloom.fullName());
        assertEquals("Undefined.", bloom.humanFullName());
        assertEquals("キュアブルーム", bloom.precureName());
        assertEquals("樹元オリエ", bloom.castName());
        assertEquals(LocalDate.of(2006, 2, 5), bloom.createdDate());
        assertEquals(PrecureColor.PINK, bloom.color());
        assertTrue(bloom.hasBirthday());
        assertEquals("8/7", bloom.birthday());
        assertEquals("デュアル・スピリチュアル・パワー！\n" +
                        "花開け大地に！\n" +
                        "輝く金の花！ キュアブルーム！\n" +
                        "ふたりはプリキュア！\n" +
                        "聖なる泉を汚す者よ！\n" +
                        "阿漕な真似はお止めなさい！",
                bloom.getTransformMessage());
        assertEquals(0, bloom.getExtraNames().size());
        assertEquals(1, bloom.getAttackMessages().size());
        assertEquals("大地の精霊よ\n" +
                        "大空の精霊よ\n" +
                        "今、プリキュアと共に！\n" +
                        "奇跡の力を解き放て！\n" +
                        "プリキュア　ツインストリーム・スプラッシュ！！",
                bloom.getAttackMessages().get(0));
        assertEquals(List.of("dual_spiritual_power"), bloom.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(bloom, Girl.byName("bloom"));
    }

    @Test
    void 変身(){
        bloom.humanize();

        assertEquals("日向咲", bloom.name());
        bloom.transform();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "花開け大地に！",
                        "輝く金の花！ キュアブルーム！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアブルーム", bloom.name());

        messageTester.messages.clear();
        bloom.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("日向咲", bloom.name());

        messageTester.messages.clear();
        bloom.dualSpiritualPower();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "花開け大地に！",
                        "輝く金の花！ キュアブルーム！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアブルーム", bloom.name());

        messageTester.messages.clear();
        bloom.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("日向咲", bloom.name());
    }

    @Test
    void 攻撃(){
        bloom.humanize();
        assertThrows(RequireTransformException.class, () -> bloom.attack(), "Require transform.");

        bloom.transform();
        messageTester.messages.clear();
        bloom.attack();
        assertEquals(List.of("大地の精霊よ",
                        "大空の精霊よ",
                        "今、プリキュアと共に！",
                        "奇跡の力を解き放て！",
                        "プリキュア　ツインストリーム・スプラッシュ！！"),
                messageTester.messages);
    }
}
