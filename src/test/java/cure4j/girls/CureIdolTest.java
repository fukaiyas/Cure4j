package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureIdolTest extends GirlTestBase {

    CureIdol idol = Cure.idol;

    @Test
    void 基本情報(){
        assertEquals("cure_idol", idol.girlName());
        assertEquals("咲良うた", idol.humanName());
        assertEquals("咲良うた", idol.fullName());
        assertEquals("Undefined.", idol.humanFullName());
        assertEquals("キュアアイドル", idol.precureName());
        assertEquals("松岡美里", idol.castName());
        assertEquals(LocalDate.of(2025, 2, 2), idol.createdDate());
        assertEquals(PrecureColor.PINK, idol.color());
        assertEquals("3/27", idol.birthday());
        assertEquals("""
                        プリキュア！ライトアップ！
                        キラキラドレスチェンジ！YEAH!
                        きみと～！ YEAH！
                        一緒にYEAH!
                        キミと歌う、ハートのキラキラ！
                        笑顔ニッコリ、キュアアイドル！
                        ウィーアー！キミとアイドルプリキュア！""",
                idol.getTransformMessage());
        assertEquals(0, idol.getExtraNames().size());
        assertEquals(1, idol.getAttackMessages().size());
        assertEquals("""
                        クライマックスは私！
                        盛り上がっていくよ！
                        キミのハートに
                        とびきり元気をあげるね
                        ゼッタイ！（ゼッタイ！）アイドル！（アイドル！）
                        ドキドキが止まらない！
                        急接近
                        笑顔のユニゾン
                        応えてほしいなっ
                        サンキュー
                        最高のステージで
                        キミと歌を
                        咲かそう
                        プリキュアアイドルスマイリング！""",
                idol.getAttackMessages().get(0));
        assertEquals(List.of("light_up"), idol.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(idol, Girl.byName("idol"));
    }

    @Test
    void 変身(){
        idol.humanize();

        assertEquals("咲良うた", idol.name());
        idol.transform();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラドレスチェンジ！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "キミと歌う、ハートのキラキラ！",
                "笑顔ニッコリ、キュアアイドル！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアアイドル", idol.name());

        messageTester.messages.clear();
        idol.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("咲良うた", idol.name());

        messageTester.messages.clear();
        idol.lightUp();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラドレスチェンジ！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "キミと歌う、ハートのキラキラ！",
                "笑顔ニッコリ、キュアアイドル！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアアイドル", idol.name());

        messageTester.messages.clear();
        idol.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("咲良うた", idol.name());
    }

    @Test
    void 攻撃(){
        idol.humanize();
        assertThrows(RequireTransformException.class, () -> idol.attack(), "Require transform.");

        idol.transform();
        messageTester.messages.clear();
        idol.attack();
        assertEquals(List.of("クライマックスは私！",
                "盛り上がっていくよ！",
                "キミのハートに",
                "とびきり元気をあげるね",
                "ゼッタイ！（ゼッタイ！）アイドル！（アイドル！）",
                "ドキドキが止まらない！",
                "急接近",
                "笑顔のユニゾン",
                "応えてほしいなっ",
                "サンキュー",
                "最高のステージで",
                "キミと歌を",
                "咲かそう",
                "プリキュアアイドルスマイリング！"),
                messageTester.messages);
    }
}
