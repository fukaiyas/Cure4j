package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureSunshineTest extends GirlTestBase {

    CureSunshine sunshine = Cure.sunshine;

    @Test
    void 基本情報(){
        assertEquals("cure_sunshine", sunshine.girlName());
        assertEquals("明堂院いつき", sunshine.humanName());
        assertEquals("明堂院いつき", sunshine.fullName());
        assertEquals("Undefined.", sunshine.humanFullName());
        assertEquals("キュアサンシャイン", sunshine.precureName());
        assertEquals("桑島法子", sunshine.castName());
        assertEquals(LocalDate.of(2010, 7, 18), sunshine.createdDate());
        assertEquals(PrecureColor.YELLOW, sunshine.color());
        assertFalse(sunshine.hasBirthday());
        assertEquals("(プリキュアの種、いくですぅ！)\n" +
                "プリキュア！オープンマイハート！\n" +
                "陽の光浴びる一輪の花！ キュアサンシャイン！\n" +
                "ハートキャッチ、プリキュア！",
                sunshine.getTransformMessage());
        assertEquals(List.of("スーパーキュアサンシャイン"), sunshine.getExtraNames());
        assertEquals(2, sunshine.getAttackMessages().size());
        assertEquals("花よ、舞い踊れ！\n" +
                "プリキュア！ゴールドフォルテバースト！！",
                sunshine.getAttackMessages().get(0));
        assertEquals("花よ、咲き誇れ！\n" +
                "プリキュア・ハートキャッチ・オーケストラ！！",
                sunshine.getAttackMessages().get(1));
        assertEquals(List.of("open_my_heart"), sunshine.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(sunshine, Girl.byName("sunshine"));
    }

    @Test
    void 変身(){
        sunshine.humanize();

        assertEquals("明堂院いつき", sunshine.name());
        sunshine.transform();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "陽の光浴びる一輪の花！ キュアサンシャイン！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアサンシャイン", sunshine.name());

        messageTester.messages.clear();
        sunshine.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアサンシャイン", sunshine.name());

        messageTester.messages.clear();
        sunshine.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("明堂院いつき", sunshine.name());

        messageTester.messages.clear();
        sunshine.openMyHeart();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "陽の光浴びる一輪の花！ キュアサンシャイン！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアサンシャイン", sunshine.name());

        messageTester.messages.clear();
        sunshine.openMyHeart();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアサンシャイン", sunshine.name());

        messageTester.messages.clear();
        sunshine.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("明堂院いつき", sunshine.name());
    }

    @Test
    void 攻撃(){
        sunshine.humanize();
        assertThrows(RequireTransformException.class, () -> sunshine.attack(), "Require transform.");

        sunshine.transform();
        messageTester.messages.clear();
        sunshine.attack();
        assertEquals(List.of("花よ、舞い踊れ！",
                "プリキュア！ゴールドフォルテバースト！！"),
                messageTester.messages);

        sunshine.transform();
        messageTester.messages.clear();
        sunshine.attack();
        assertEquals(List.of("花よ、咲き誇れ！",
                "プリキュア・ハートキャッチ・オーケストラ！！"),
                messageTester.messages);
    }
}
