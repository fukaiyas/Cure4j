package cure4j.girls;

import static cure4j.Cure4j.Cure;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CureBlackTest {

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
        assertEquals("デュアル・オーロラ・ウェイブ！！\n光の使者、キュアブラック！\nふたりはプリキュア！\n闇の力のしもべ達よ！\nとっととお家に帰りなさい！", black.getTransformMessage());
        assertEquals(0, black.getExtraNames().size());
        assertEquals(1, black.getAttackMessages().size());
        assertEquals("ブラックサンダー！\nホワイトサンダー！\nプリキュアの美しき魂が！\n邪悪な心を打ち砕く！\nプリキュア・マーブル・スクリュー！！\nマックス！！", black.getAttackMessages().get(0));
        assertEquals(1, black.getTransformCalls().size());
        assertEquals("dual_aurora_wave", black.getTransformCalls().get(0));
    }

    @Test
    void エイリアス(){
        assertEquals(black, Girl.byName("black"));
    }

    @Test
    void 変身(){
        Girl.sleepSec = 0;
        black.humanize();

        assertEquals("美墨なぎさ", black.name());
        //TODO System.outもテストしたい？
        black.transform();
        assertEquals("キュアブラック", black.name());
        black.transform();
        assertEquals("美墨なぎさ", black.name());
        black.dualAuroraWave();
        assertEquals("キュアブラック", black.name());
        black.humanize();
        assertEquals("美墨なぎさ", black.name());
    }

    @Test
    void 攻撃(){
        Girl.sleepSec = 0;
        black.humanize();

        assertThrows(RequireTransformException.class, () -> black.attack(), "Require transform.");
        black.transform();
        black.attack();
        //TODO System.outもテストしたい？
    }
}
