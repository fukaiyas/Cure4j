package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurePapayaTest extends GirlTestBase {

    CurePapaya papaya = Cure.papaya;

    @Test
    void 基本情報(){
        assertEquals("cure_papaya", papaya.girlName());
        assertEquals("一ノ瀬みのり", papaya.humanName());
        assertEquals("一ノ瀬みのり", papaya.fullName());
        assertEquals("Undefined.", papaya.humanFullName());
        assertEquals("キュアパパイア", papaya.precureName());
        assertEquals("石川由依", papaya.castName());
        assertEquals(LocalDate.of(2021, 3, 21), papaya.createdDate());
        assertEquals(PrecureColor.YELLOW, papaya.color());
        assertEquals("11/21", papaya.birthday());
        assertEquals("プリキュア！トロピカルチェンジ！\n" +
                "レッツメイク！キャッチ！\n" +
                "チーク！\n" +
                "リップ！\n" +
                "ヘアー！\n" +
                "アイズ！\n" +
                "ドレス！\n" +
                "ひらめく果実！キュアパパイア！",
                papaya.getTransformMessage());
        assertEquals(0, papaya.getExtraNames().size());
        assertEquals(1, papaya.getAttackMessages().size());
        assertEquals("ハートルージュロッド！\n" +
                "プリキュア！ぱんぱかパパイアショット！\n" +
                "ビクトリー！",
                papaya.getAttackMessages().get(0));
        assertEquals(List.of("precure_tropical_change"),
                            papaya.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(papaya, Girl.byName("papaya"));
    }

    @Test
    void 変身(){
        papaya.humanize();

        assertEquals("一ノ瀬みのり", papaya.name());
        papaya.transform();
        assertEquals(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "チーク！",
                "リップ！",
                "ヘアー！",
                "アイズ！",
                "ドレス！",
                "ひらめく果実！キュアパパイア！"),
                messageTester.messages);
        assertEquals("キュアパパイア", papaya.name());

        messageTester.messages.clear();
        papaya.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("一ノ瀬みのり", papaya.name());

        messageTester.messages.clear();
        papaya.tropicalChange();
        assertEquals(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "チーク！",
                "リップ！",
                "ヘアー！",
                "アイズ！",
                "ドレス！",
                "ひらめく果実！キュアパパイア！"),
                messageTester.messages);
        assertEquals("キュアパパイア", papaya.name());

        messageTester.messages.clear();
        papaya.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("一ノ瀬みのり", papaya.name());
    }

    @Test
    void 攻撃(){
        papaya.humanize();
        assertThrows(RequireTransformException.class, () -> papaya.attack(), "Require transform.");

        papaya.transform();
        messageTester.messages.clear();
        papaya.attack();
        assertEquals(List.of("ハートルージュロッド！",
                "プリキュア！ぱんぱかパパイアショット！",
                "ビクトリー！"),
                messageTester.messages);
    }
}
