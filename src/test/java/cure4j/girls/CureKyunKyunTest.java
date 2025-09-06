package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureKyunKyunTest extends GirlTestBase {

    CureKyunKyun kyunkyun = Cure.kyunkyun;

    @Test
    void 基本情報(){
        assertEquals("cure_kyunkyun", kyunkyun.girlName());
        assertEquals("紫雨こころ", kyunkyun.humanName());
        assertEquals("紫雨こころ", kyunkyun.fullName());
        assertEquals("Undefined.", kyunkyun.humanFullName());
        assertEquals("キュアキュンキュン", kyunkyun.precureName());
        assertEquals("高森奈津美", kyunkyun.castName());
        assertEquals(LocalDate.of(2025, 3, 23), kyunkyun.createdDate());
        assertEquals(PrecureColor.PURPLE, kyunkyun.color());
        assertEquals("5/11", kyunkyun.birthday());
        assertEquals("""
                        プリキュア！ライトアップ！
                        キラキラドレスチェンジ！YEAH!
                        きみと～！ YEAH！
                        一緒にYEAH!
                        キミと踊る、ハートのリズム！
                        心キュンキュン、キュアキュンキュン！
                        ウィーアー！キミとアイドルプリキュア！""",
                kyunkyun.getTransformMessage());
        assertEquals(0, kyunkyun.getExtraNames().size());
        assertEquals(1, kyunkyun.getAttackMessages().size());
        assertEquals("""
                        クライマックスは私！
                        準備はOK?
                        ねえキミも！
                        かわいーな（キュンキュン！）
                        かっこいーな（キュンキュン！）
                        完全同意に
                        アガる
                        テンション
                        コーレスプリーズ（イェイ☆）
                        とびきりキュンキュン響かせて
                        踊ろう
                        Let's dance!!
                        もう1回（キュンキュン！）
                        アンコール（キュンキュン！）
                        完全ダイスキ
                        ハイなステップが
                        ナンバーワン
                        もっと夢中になれるね
                        こころビート
                        YES!キュンキュン♪
                        プリキュアキュンキュンビート！""",
                kyunkyun.getAttackMessages().get(0));
        assertEquals(List.of("light_up"), kyunkyun.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(kyunkyun, Girl.byName("kyunkyun"));
    }

    @Test
    void 変身(){
        kyunkyun.humanize();

        assertEquals("紫雨こころ", kyunkyun.name());
        kyunkyun.transform();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラドレスチェンジ！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "キミと踊る、ハートのリズム！",
                "心キュンキュン、キュアキュンキュン！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアキュンキュン", kyunkyun.name());

        messageTester.messages.clear();
        kyunkyun.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("紫雨こころ", kyunkyun.name());

        messageTester.messages.clear();
        kyunkyun.lightUp();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラドレスチェンジ！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "キミと踊る、ハートのリズム！",
                "心キュンキュン、キュアキュンキュン！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアキュンキュン", kyunkyun.name());

        messageTester.messages.clear();
        kyunkyun.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("紫雨こころ", kyunkyun.name());
    }

    @Test
    void 攻撃(){
        kyunkyun.humanize();
        assertThrows(RequireTransformException.class, () -> kyunkyun.attack(), "Require transform.");

        kyunkyun.transform();
        messageTester.messages.clear();
        kyunkyun.attack();
        assertEquals(List.of("クライマックスは私！",
                "準備はOK?",
                "ねえキミも！",
                "かわいーな（キュンキュン！）",
                "かっこいーな（キュンキュン！）",
                "完全同意に",
                "アガる",
                "テンション",
                "コーレスプリーズ（イェイ☆）",
                "とびきりキュンキュン響かせて",
                "踊ろう",
                "Let's dance!!",
                "もう1回（キュンキュン！）",
                "アンコール（キュンキュン！）",
                "完全ダイスキ",
                "ハイなステップが",
                "ナンバーワン",
                "もっと夢中になれるね",
                "こころビート",
                "YES!キュンキュン♪",
                "プリキュアキュンキュンビート！"),
                messageTester.messages);
    }
}
