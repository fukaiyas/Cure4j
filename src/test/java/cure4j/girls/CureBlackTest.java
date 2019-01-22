package cure4j.girls;

import static cure4j.Cure4j.Cure;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CureBlackTest extends GirlTestBase {

    CureBlack black = Cure.black;

    @Test
    void 基本情報(){
        assertEquals("cure_black", black.girlName());
        assertEquals("美墨なぎさ", black.humanName());
        assertEquals("Undefined.", black.humanFullName());
        assertEquals("キュアブラック", black.precureName());
        assertEquals("本名陽子", black.castName());
        assertEquals(LocalDate.of(2004, 2, 1), black.createdDate());
        assertEquals(PrecureColor.BLACK, black.color());
        assertTrue(black.hasBirthday());
        assertEquals("10/10", black.birthday());
        assertEquals("デュアル・オーロラ・ウェイブ！！\n" +
                "光の使者、キュアブラック！\n" +
                "ふたりはプリキュア！\n" +
                "闇の力のしもべ達よ！\n" +
                "とっととお家に帰りなさい！",
                black.getTransformMessage());
        assertEquals(0, black.getExtraNames().size());
        assertEquals(1, black.getAttackMessages().size());
        assertEquals("ブラックサンダー！\n" +
                "ホワイトサンダー！\n" +
                "プリキュアの美しき魂が！\n" +
                "邪悪な心を打ち砕く！\n" +
                "プリキュア・マーブル・スクリュー！！\n" +
                "マックス！！",
                black.getAttackMessages().get(0));
        assertEquals(1, black.getTransformCalls().size());
        assertEquals("dual_aurora_wave", black.getTransformCalls().get(0));
    }

    @Test
    void エイリアス(){
        assertEquals(black, Girl.byName("black"));
    }

    @Test
    void 変身(){
        black.humanize();

        assertEquals("美墨なぎさ", black.name());
        black.transform();
        assertEquals(List.of("デュアル・オーロラ・ウェイブ！！",
                "光の使者、キュアブラック！",
                "ふたりはプリキュア！",
                "闇の力のしもべ達よ！",
                "とっととお家に帰りなさい！"),
                messageTester.messages);
        assertEquals("キュアブラック", black.name());

        messageTester.messages.clear();
        black.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美墨なぎさ", black.name());

        messageTester.messages.clear();
        black.dualAuroraWave();
        assertEquals(List.of("デュアル・オーロラ・ウェイブ！！",
                "光の使者、キュアブラック！",
                "ふたりはプリキュア！",
                "闇の力のしもべ達よ！",
                "とっととお家に帰りなさい！"),
                messageTester.messages);
        assertEquals("キュアブラック", black.name());

        messageTester.messages.clear();
        black.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美墨なぎさ", black.name());
    }

    @Test
    void 攻撃(){
        black.humanize();
        assertThrows(RequireTransformException.class, () -> black.attack(), "Require transform.");

        black.transform();
        messageTester.messages.clear();
        black.attack();
        assertEquals(List.of("ブラックサンダー！",
                "ホワイトサンダー！",
                "プリキュアの美しき魂が！",
                "邪悪な心を打ち砕く！",
                "プリキュア・マーブル・スクリュー！！",
                "マックス！！"),
                messageTester.messages);
    }
}
