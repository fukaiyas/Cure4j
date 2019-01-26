package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureWhiteTest extends GirlTestBase {

    CureWhite white = Cure.white;
    
    @Test
    void 基本情報(){
        assertEquals("cure_white", white.girlName());
        assertEquals("雪城ほのか", white.humanName());
        assertEquals("雪城ほのか", white.fullName());
        assertEquals("Undefined.", white.humanFullName());
        assertEquals("キュアホワイト", white.precureName());
        assertEquals("ゆかな", white.castName());
        assertEquals(LocalDate.of(2004, 2, 1), white.createdDate());
        assertEquals(PrecureColor.WHITE, white.color());
        assertTrue(white.hasBirthday());
        assertEquals("4/4", white.birthday());
        assertEquals("デュアル・オーロラ・ウェイブ！！\n" +
                        "光の使者、キュアホワイト！\n" +
                        "ふたりはプリキュア！\n" +
                        "闇の力のしもべ達よ！\n" +
                        "とっととお家に帰りなさい！",
                white.getTransformMessage());
        assertEquals(0, white.getExtraNames().size());
        assertEquals(1, white.getAttackMessages().size());
        assertEquals("ブラックサンダー！\n" +
                        "ホワイトサンダー！\n" +
                        "プリキュアの美しき魂が！\n" +
                        "邪悪な心を打ち砕く！\n" +
                        "プリキュア・マーブル・スクリュー！！\n" +
                        "マックス！！",
                white.getAttackMessages().get(0));
        assertEquals(List.of("dual_aurora_wave"), white.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(white, Girl.byName("white"));
    }

    @Test
    void 変身(){
        white.humanize();

        assertEquals("雪城ほのか", white.name());
        white.transform();
        assertEquals(List.of("デュアル・オーロラ・ウェイブ！！",
                "光の使者、キュアホワイト！",
                "ふたりはプリキュア！",
                "闇の力のしもべ達よ！",
                "とっととお家に帰りなさい！"),
                messageTester.messages);
        assertEquals("キュアホワイト", white.name());

        messageTester.messages.clear();
        white.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("雪城ほのか", white.name());

        messageTester.messages.clear();
        white.dualAuroraWave();
        assertEquals(List.of("デュアル・オーロラ・ウェイブ！！",
                "光の使者、キュアホワイト！",
                "ふたりはプリキュア！",
                "闇の力のしもべ達よ！",
                "とっととお家に帰りなさい！"),
                messageTester.messages);
        assertEquals("キュアホワイト", white.name());

        messageTester.messages.clear();
        white.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("雪城ほのか", white.name());
    }

    @Test
    void 攻撃(){
        white.humanize();
        assertThrows(RequireTransformException.class, () -> white.attack(), "Require transform.");

        white.transform();
        messageTester.messages.clear();
        white.attack();
        assertEquals(List.of("ブラックサンダー！",
                "ホワイトサンダー！",
                "プリキュアの美しき魂が！",
                "邪悪な心を打ち砕く！",
                "プリキュア・マーブル・スクリュー！！",
                "マックス！！"),
                messageTester.messages);
    }
}
