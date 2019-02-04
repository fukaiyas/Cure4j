package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureBlossomTest extends GirlTestBase {

    CureBlossom blossom = Cure.blossom;

    @Test
    void 基本情報(){
        assertEquals("cure_blossom", blossom.girlName());
        assertEquals("花咲つぼみ", blossom.humanName());
        assertEquals("花咲つぼみ", blossom.fullName());
        assertEquals("Undefined.", blossom.humanFullName());
        assertEquals("キュアブロッサム", blossom.precureName());
        assertEquals("水樹奈々", blossom.castName());
        assertEquals(LocalDate.of(2010, 2, 7), blossom.createdDate());
        assertEquals(PrecureColor.PINK, blossom.color());
        assertFalse(blossom.hasBirthday());
        assertEquals("(プリキュアの種、いくですぅ！)\n" +
                "プリキュア！オープンマイハート！\n" +
                "大地に咲く一輪の花！ キュアブロッサム！\n" +
                "ハートキャッチ、プリキュア！",
                blossom.getTransformMessage());
        assertEquals(List.of("スーパーキュアブロッサム"), blossom.getExtraNames());
        assertEquals(2, blossom.getAttackMessages().size());
        assertEquals("花よ輝け！\n" +
                "プリキュア！ピンクフォルテウェイブ！！",
                blossom.getAttackMessages().get(0));
        assertEquals("花よ、咲き誇れ！\n" +
                "プリキュア・ハートキャッチ・オーケストラ！！",
                blossom.getAttackMessages().get(1));
        assertEquals(List.of("open_my_heart"), blossom.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(blossom, Girl.byName("blossom"));
    }

    @Test
    void 変身(){
        blossom.humanize();

        assertEquals("花咲つぼみ", blossom.name());
        blossom.transform();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "大地に咲く一輪の花！ キュアブロッサム！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアブロッサム", blossom.name());

        messageTester.messages.clear();
        blossom.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアブロッサム", blossom.name());

        messageTester.messages.clear();
        blossom.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("花咲つぼみ", blossom.name());

        messageTester.messages.clear();
        blossom.openMyHeart();
        assertEquals(List.of("(プリキュアの種、いくですぅ！)",
                "プリキュア！オープンマイハート！",
                "大地に咲く一輪の花！ キュアブロッサム！",
                "ハートキャッチ、プリキュア！"),
                messageTester.messages);
        assertEquals("キュアブロッサム", blossom.name());

        messageTester.messages.clear();
        blossom.openMyHeart();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("スーパーキュアブロッサム", blossom.name());

        messageTester.messages.clear();
        blossom.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("花咲つぼみ", blossom.name());
    }

    @Test
    void 攻撃(){
        blossom.humanize();
        assertThrows(RequireTransformException.class, () -> blossom.attack(), "Require transform.");

        blossom.transform();
        messageTester.messages.clear();
        blossom.attack();
        assertEquals(List.of("花よ輝け！",
                "プリキュア！ピンクフォルテウェイブ！！"),
                messageTester.messages);

        blossom.transform();
        messageTester.messages.clear();
        blossom.attack();
        assertEquals(List.of("花よ、咲き誇れ！",
                "プリキュア・ハートキャッチ・オーケストラ！！"),
                messageTester.messages);
    }
}
