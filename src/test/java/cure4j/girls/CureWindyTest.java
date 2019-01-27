package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureWindyTest extends GirlTestBase {

    CureWindy windy = Cure.windy;

    @Test
    void 基本情報(){
        assertEquals("cure_egret", windy.girlName());
        assertEquals("美翔舞", windy.humanName());
        assertEquals("美翔舞", windy.fullName());
        assertEquals("Undefined.", windy.humanFullName());
        assertEquals("キュアウィンディ", windy.precureName());
        assertEquals("榎本温子", windy.castName());
        assertEquals(LocalDate.of(2006, 9, 3), windy.createdDate());
        assertEquals(PrecureColor.WHITE, windy.color());
        assertTrue(windy.hasBirthday());
        assertEquals("11/20", windy.birthday());
        assertEquals("デュアル・スピリチュアル・パワー！\n" +
                        "勇気を運べ！\n" +
                        "大地に薫る風！ キュアウィンディ！\n" +
                        "ふたりはプリキュア！\n" +
                        "聖なる泉を汚す者よ！\n" +
                        "阿漕な真似はお止めなさい！",
                windy.getTransformMessage());
        assertEquals(0, windy.getExtraNames().size());
        assertEquals(1, windy.getAttackMessages().size());
        assertEquals("精霊の光よ、命の煌きよ！\n" +
                        "希望へ導け、2つの心！\n" +
                        "プリキュア・スパイラルスタースプラッシュ！！",
                windy.getAttackMessages().get(0));
        assertEquals(List.of("dual_spiritual_power"), windy.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(windy, Girl.byName("windy"));
    }

    @Test
    void 変身(){
        windy.humanize();

        assertEquals("美翔舞", windy.name());
        windy.transform();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "勇気を運べ！",
                        "大地に薫る風！ キュアウィンディ！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアウィンディ", windy.name());

        messageTester.messages.clear();
        windy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美翔舞", windy.name());

        messageTester.messages.clear();
        windy.dualSpiritualPower();
        assertEquals(List.of("デュアル・スピリチュアル・パワー！",
                        "勇気を運べ！",
                        "大地に薫る風！ キュアウィンディ！",
                        "ふたりはプリキュア！",
                        "聖なる泉を汚す者よ！",
                        "阿漕な真似はお止めなさい！"),
                messageTester.messages);
        assertEquals("キュアウィンディ", windy.name());

        messageTester.messages.clear();
        windy.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美翔舞", windy.name());
    }

    @Test
    void 攻撃(){
        windy.humanize();
        assertThrows(RequireTransformException.class, () -> windy.attack(), "Require transform.");

        windy.transform();
        messageTester.messages.clear();
        windy.attack();
        assertEquals(List.of("精霊の光よ、命の煌きよ！",
                        "希望へ導け、2つの心！",
                        "プリキュア・スパイラルスタースプラッシュ！！"),
                messageTester.messages);
    }
}
