package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureMarineTest extends GirlTestBase {

    CureMarine marine = Cure.marine;

    @Test
    void 基本情報(){
        assertEquals("cure_marine", marine.girlName());
        assertEquals("来海えりか", marine.humanName());
        assertEquals("来海えりか", marine.fullName());
        assertEquals("Undefined.", marine.humanFullName());
        assertEquals("キュアマリン", marine.precureName());
        assertEquals("水沢史絵", marine.castName());
        assertEquals(LocalDate.of(2010, 2, 21), marine.createdDate());
        assertEquals(PrecureColor.BLUE, marine.color());
        assertFalse(marine.hasBirthday());
        assertEquals("(プリキュアの種、いくですぅ！)\n" +
                "プリキュア！オープンマイハート！\n" +
                "海風に揺れる一輪の花！ キュアマリン！\n" +
                "ハートキャッチ、プリキュア！",
                marine.getTransformMessage());
        assertEquals(List.of("スーパーキュアマリン"), marine.getExtraNames());
        assertEquals(2, marine.getAttackMessages().size());
        assertEquals("花よきらめけ！\n" +
                "プリキュア！ブルーフォルテウェイブ！！",
                marine.getAttackMessages().get(0));
        assertEquals("花よ、咲き誇れ！\n" +
                "プリキュア・ハートキャッチ・オーケストラ！！",
                marine.getAttackMessages().get(1));
        assertEquals(List.of("open_my_heart"), marine.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(marine, Girl.byName("marine"));
    }

    @Test
    void 変身(){
        marine.humanize();

        assertEquals("来海えりか", marine.name());
        marine.transform();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "海風に揺れる一輪の花！ キュアマリン！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアマリン", marine.name());

        messageTester.messages.clear();
        marine.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアマリン", marine.name());

        messageTester.messages.clear();
        marine.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("来海えりか", marine.name());

        messageTester.messages.clear();
        marine.openMyHeart();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "海風に揺れる一輪の花！ キュアマリン！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアマリン", marine.name());

        messageTester.messages.clear();
        marine.openMyHeart();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアマリン", marine.name());

        messageTester.messages.clear();
        marine.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("来海えりか", marine.name());
    }

    @Test
    void 攻撃(){
        marine.humanize();
        assertThrows(RequireTransformException.class, () -> marine.attack(), "Require transform.");

        marine.transform();
        messageTester.messages.clear();
        marine.attack();
        assertEquals(List.of("花よきらめけ！",
                "プリキュア！ブルーフォルテウェイブ！！"),
                messageTester.messages);

        marine.transform();
        messageTester.messages.clear();
        marine.attack();
        assertEquals(List.of("花よ、咲き誇れ！",
                "プリキュア・ハートキャッチ・オーケストラ！！"),
                messageTester.messages);
    }
}
