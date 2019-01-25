package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureBrightTest extends GirlTestBase {

    CureBright bright = Cure.bright;

    @Test
    void 基本情報(){
        assertEquals("cure_bloom", bright.girlName);
        assertEquals("日向咲", bright.humanName());
        assertEquals("日向咲", bright.fullName());
        assertEquals("Undefined.", bright.humanFullName());
        assertEquals("キュアブライト", bright.precureName());
        assertEquals("樹元オリエ", bright.castName());
        assertEquals(LocalDate.of(2006, 9, 3), bright.createdDate());
        assertEquals(PrecureColor.YELLOW, bright.color());
        assertTrue(bright.hasBirthday());
        assertEquals("8/7", bright.birthday());
        assertEquals("デュアル・スピリチュアル・パワー！\n" +
                        "未来を照らし！\n" +
                        "天空に満ちる月！ キュアブライト！\n" +
                        "ふたりはプリキュア！\n" +
                        "聖なる泉を汚す者よ！\n" +
                        "阿漕な真似はお止めなさい！",
                bright.getTransformMessage());
        assertEquals(0, bright.getExtraNames().size());
        assertEquals(1, bright.getAttackMessages().size());
        assertEquals("精霊の光よ、命の煌きよ！\n" +
                        "希望へ導け、2つの心！\n" +
                        "プリキュア・スパイラルスタースプラッシュ！！",
                bright.getAttackMessages().get(0));
        assertEquals(1, bright.getTransformCalls().size());
        assertEquals("dual_spiritual_power", bright.getTransformCalls().get(0));
    }

    @Test
    void エイリアス(){
        assertEquals(bright, Girl.byName("bright"));
    }

    @Test
    void 変身(){
        bright.humanize();

        assertEquals("日向咲", bright.name());
        bright.transform();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "未来を照らし！",
                        "天空に満ちる月！ キュアブライト！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアブライト", bright.name());

        messageTester.messages.clear();
        bright.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("日向咲", bright.name());

        messageTester.messages.clear();
        bright.dualSpiritualPower();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "未来を照らし！",
                        "天空に満ちる月！ キュアブライト！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアブライト", bright.name());

        messageTester.messages.clear();
        bright.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("日向咲", bright.name());
    }

    @Test
    void 攻撃(){
        bright.humanize();
        assertThrows(RequireTransformException.class, () -> bright.attack(), "Require transform.");

        bright.transform();
        messageTester.messages.clear();
        bright.attack();
        assertEquals(List.of("精霊の光よ、命の煌きよ！",
                        "希望へ導け、2つの心！",
                        "プリキュア・スパイラルスタースプラッシュ！！"),
                messageTester.messages);
    }
}
