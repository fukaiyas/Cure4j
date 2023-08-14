package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureYumyumTest extends GirlTestBase {

    CureYumyum yumyum = Cure.yumyum;

    @Test
    void 基本情報(){
        assertEquals("cure_yumyum", yumyum.girlName());
        assertEquals("華満らん", yumyum.humanName());
        assertEquals("華満らん", yumyum.fullName());
        assertEquals("Undefined.", yumyum.humanFullName());
        assertEquals("キュアヤムヤム", yumyum.precureName());
        assertEquals("井口裕香", yumyum.castName());
        assertEquals(LocalDate.of(2022, 4, 24), yumyum.createdDate());
        assertEquals(PrecureColor.YELLOW, yumyum.color());
        assertTrue(yumyum.hasBirthday());
        assertEquals("7/11", yumyum.birthday());
        assertEquals("メン！\n" +
                "プリキュア！デリシャスタンバイ！\n" +
                "Party Go!\n" +
                "クルクル！\n" +
                "メンメン！\n" +
                "ミラクル！\n" +
                "メンメン！\n" +
                "シェアリングエナジー！\n" +
                "ワンタン！\n" +
                "メンメン！\n" +
                "きらめくヌードル・エモーション！\n" +
                "キュアヤムヤム！\n" +
                "おいしいの独り占め、ゆるさないよ！\n" +
                "デリシャスパーティ♡プリキュア！",
                yumyum.getTransformMessage());
        assertEquals(0, yumyum.getExtraNames().size());
        assertEquals(1, yumyum.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "プリキュア！ヤムヤムラインズ！\n" +
                "はー！\n" +
                "はー！\n" +
                "お腹いっぱい\n" +
                "ごちそうさまでした！"),
                yumyum.getAttackMessages().get(0));
        assertEquals(List.of("delicioustandby"),
                            yumyum.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(yumyum, Girl.byName("yumyum"));
    }

    @Test
    void 変身(){
        yumyum.humanize();

        assertEquals("華満らん", yumyum.name());
        yumyum.transform();
        assertEquals(List.of("メン！",
                "プリキュア！デリシャスタンバイ！",
                "Party Go!",
                "クルクル！",
                "メンメン！",
                "ミラクル！",
                "メンメン！",
                "シェアリングエナジー！",
                "ワンタン！",
                "メンメン！",
                "きらめくヌードル・エモーション！",
                "キュアヤムヤム！",
                "おいしいの独り占め、ゆるさないよ！",
                "デリシャスパーティ♡プリキュア！"),
                messageTester.messages);
        assertEquals("キュアヤムヤム", yumyum.name());

        messageTester.messages.clear();
        yumyum.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("華満らん", yumyum.name());

        messageTester.messages.clear();
        yumyum.delicioustandby();
        assertEquals(List.of("メン！",
                "プリキュア！デリシャスタンバイ！",
                "Party Go!",
                "クルクル！",
                "メンメン！",
                "ミラクル！",
                "メンメン！",
                "シェアリングエナジー！",
                "ワンタン！",
                "メンメン！",
                "きらめくヌードル・エモーション！",
                "キュアヤムヤム！",
                "おいしいの独り占め、ゆるさないよ！",
                "デリシャスパーティ♡プリキュア！"),
                messageTester.messages);
        assertEquals("キュアヤムヤム", yumyum.name());

        messageTester.messages.clear();
        yumyum.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("華満らん", yumyum.name());
    }

    @Test
    void 攻撃(){
        yumyum.humanize();
        assertThrows(RequireTransformException.class, () -> yumyum.attack(), "Require transform.");

        yumyum.transform();
        messageTester.messages.clear();
        yumyum.attack();
        assertEquals(List.of("プリキュア！ヤムヤムラインズ！",
                "はー！",
                "はー！",
                "お腹いっぱい",
                "ごちそうさまでした！"),
                messageTester.messages);
    }
}
