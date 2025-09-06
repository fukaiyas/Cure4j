package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureZukyoonTest extends GirlTestBase {

    CureZukyoon zukyoon = Cure.zukyoon;

    @Test
    void 基本情報(){
        assertEquals("cure_zukyoon", zukyoon.girlName());
        assertEquals("プリルン", zukyoon.humanName());
        assertEquals("プリルン", zukyoon.fullName());
        assertEquals("Undefined.", zukyoon.humanFullName());
        assertEquals("キュアズキューン", zukyoon.precureName());
        assertEquals("南條愛乃", zukyoon.castName());
        assertEquals(LocalDate.of(2025, 6, 15), zukyoon.createdDate());
        assertEquals(PrecureColor.WHITE, zukyoon.color());
        assertEquals("10/9", zukyoon.birthday());
        assertEquals("""
                        プリキュア！ライトアップ！
                        キラキラショータイム！YEAH!
                        きみと～！ YEAH！
                        一緒にYEAH!
                        ハートをプリっとロックオン！
                        キミとズッキュン、キュアズキューン！
                        ウィーアー！キミとアイドルプリキュア！""",
                zukyoon.getTransformMessage());
        assertEquals(0, zukyoon.getExtraNames().size());
        assertEquals(1, zukyoon.getAttackMessages().size());
        assertEquals("""
                        ふたりの誓い、いま輝け！
                        取り戻したい
                        光の世界
                        その笑顔
                        勇気
                        涙
                        夢
                        希望の兆し
                        キミと明日を
                        願うチカラで
                        うまれる
                        わたし達のハーモニー
                        響け
                        プリキュア！ズキューンキッスディスティニー！""",
                zukyoon.getAttackMessages().get(0));
        assertEquals(List.of("light_up"), zukyoon.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(zukyoon, Girl.byName("zukyoon"));
    }

    @Test
    void 変身(){
        zukyoon.humanize();

        assertEquals("プリルン", zukyoon.name());
        zukyoon.transform();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラショータイム！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "ハートをプリっとロックオン！",
                "キミとズッキュン、キュアズキューン！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアズキューン", zukyoon.name());

        messageTester.messages.clear();
        zukyoon.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリルン", zukyoon.name());

        messageTester.messages.clear();
        zukyoon.lightUp();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラショータイム！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "ハートをプリっとロックオン！",
                "キミとズッキュン、キュアズキューン！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアズキューン", zukyoon.name());

        messageTester.messages.clear();
        zukyoon.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリルン", zukyoon.name());
    }

    @Test
    void 攻撃(){
        zukyoon.humanize();
        assertThrows(RequireTransformException.class, () -> zukyoon.attack(), "Require transform.");

        zukyoon.transform();
        messageTester.messages.clear();
        zukyoon.attack();
        assertEquals(List.of("ふたりの誓い、いま輝け！",
                "取り戻したい",
                "光の世界",
                "その笑顔",
                "勇気",
                "涙",
                "夢",
                "希望の兆し",
                "キミと明日を",
                "願うチカラで",
                "うまれる",
                "わたし達のハーモニー",
                "響け",
                "プリキュア！ズキューンキッスディスティニー！"),
                messageTester.messages);
    }
}
