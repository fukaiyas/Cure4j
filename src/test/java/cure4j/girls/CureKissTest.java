package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureKissTest extends GirlTestBase {

    CureKiss kiss = Cure.kiss;

    @Test
    void 基本情報(){
        assertEquals("cure_kiss", kiss.girlName());
        assertEquals("メロロン", kiss.humanName());
        assertEquals("メロロン", kiss.fullName());
        assertEquals("Undefined.", kiss.humanFullName());
        assertEquals("キュアキッス", kiss.precureName());
        assertEquals("南條愛乃", kiss.castName());
        assertEquals(LocalDate.of(2025, 6, 15), kiss.createdDate());
        assertEquals(PrecureColor.BLACK, kiss.color());
        assertEquals("12/07", kiss.birthday());
        assertEquals("""
                        プリキュア！ライトアップ！
                        キラキラショータイム！YEAH!
                        きみと～！ YEAH！
                        一緒にYEAH!
                        ハートをメロっとひとりじめ！
                        キミと口づけ、キュアキッス！
                        ウィーアー！キミとアイドルプリキュア！""",
                kiss.getTransformMessage());
        assertEquals(0, kiss.getExtraNames().size());
        assertEquals(1, kiss.getAttackMessages().size());
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
                kiss.getAttackMessages().get(0));
        assertEquals(List.of("light_up"), kiss.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(kiss, Girl.byName("kiss"));
    }

    @Test
    void 変身(){
        kiss.humanize();

        assertEquals("メロロン", kiss.name());
        kiss.transform();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラショータイム！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "ハートをメロっとひとりじめ！",
                "キミと口づけ、キュアキッス！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアキッス", kiss.name());

        messageTester.messages.clear();
        kiss.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("メロロン", kiss.name());

        messageTester.messages.clear();
        kiss.lightUp();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラショータイム！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "ハートをメロっとひとりじめ！",
                "キミと口づけ、キュアキッス！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアキッス", kiss.name());

        messageTester.messages.clear();
        kiss.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("メロロン", kiss.name());
    }

    @Test
    void 攻撃(){
        kiss.humanize();
        assertThrows(RequireTransformException.class, () -> kiss.attack(), "Require transform.");

        kiss.transform();
        messageTester.messages.clear();
        kiss.attack();
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
