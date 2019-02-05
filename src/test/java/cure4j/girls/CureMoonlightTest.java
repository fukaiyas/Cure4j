package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureMoonlightTest extends GirlTestBase {

    CureMoonlight moonlight = Cure.moonlight;

    @Test
    void 基本情報(){
        assertEquals("cure_moonlight", moonlight.girlName());
        assertEquals("月影ゆり", moonlight.humanName());
        assertEquals("月影ゆり", moonlight.fullName());
        assertEquals("Undefined.", moonlight.humanFullName());
        assertEquals("キュアムーンライト", moonlight.precureName());
        assertEquals("久川綾", moonlight.castName());
        assertEquals(LocalDate.of(2010, 9, 26), moonlight.createdDate());
        assertEquals(PrecureColor.PURPLE, moonlight.color());
        assertFalse(moonlight.hasBirthday());
        assertEquals("(プリキュアの種、いくですぅ！)\n" +
                "プリキュア！オープンマイハート！\n" +
                "月光に冴える一輪の花 キュアムーンライト！\n" +
                "ハートキャッチ、プリキュア！",
                moonlight.getTransformMessage());
        assertEquals(List.of("スーパーキュアムーンライト"), moonlight.getExtraNames());
        assertEquals(2, moonlight.getAttackMessages().size());
        assertEquals("花よ輝け！\n" +
                "プリキュア！シルバーフォルテウェイブ！！",
                moonlight.getAttackMessages().get(0));
        assertEquals("花よ、咲き誇れ！\n" +
                "プリキュア・ハートキャッチ・オーケストラ！！",
                moonlight.getAttackMessages().get(1));
        assertEquals(List.of("open_my_heart"), moonlight.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(moonlight, Girl.byName("moonlight"));
    }

    @Test
    void 変身(){
        moonlight.humanize();

        assertEquals("月影ゆり", moonlight.name());
        moonlight.transform();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "月光に冴える一輪の花 キュアムーンライト！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアムーンライト", moonlight.name());

        messageTester.messages.clear();
        moonlight.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアムーンライト", moonlight.name());

        messageTester.messages.clear();
        moonlight.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("月影ゆり", moonlight.name());

        messageTester.messages.clear();
        moonlight.openMyHeart();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "月光に冴える一輪の花 キュアムーンライト！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアムーンライト", moonlight.name());

        messageTester.messages.clear();
        moonlight.openMyHeart();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアムーンライト", moonlight.name());

        messageTester.messages.clear();
        moonlight.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("月影ゆり", moonlight.name());
    }

    @Test
    void 攻撃(){
        moonlight.humanize();
        assertThrows(RequireTransformException.class, () -> moonlight.attack(), "Require transform.");

        moonlight.transform();
        messageTester.messages.clear();
        moonlight.attack();
        assertEquals(List.of("花よ輝け！",
                "プリキュア！シルバーフォルテウェイブ！！"),
                messageTester.messages);

        moonlight.transform();
        messageTester.messages.clear();
        moonlight.attack();
        assertEquals(List.of("花よ、咲き誇れ！",
                "プリキュア・ハートキャッチ・オーケストラ！！"),
                messageTester.messages);
    }
}
