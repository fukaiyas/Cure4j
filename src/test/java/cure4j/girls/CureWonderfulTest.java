package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureWonderfulTest extends GirlTestBase {

    CureWonderful wonderful = Cure.wonderful;

    @Test
    void 基本情報(){
        assertEquals("cure_wonderful", wonderful.girlName());
        assertEquals("犬飼こむぎ", wonderful.humanName());
        assertEquals("犬飼こむぎ", wonderful.fullName());
        assertEquals("Undefined.", wonderful.humanFullName());
        assertEquals("キュアワンダフル", wonderful.precureName());
        assertEquals("長縄まりあ", wonderful.castName());
        assertEquals(LocalDate.of(2024, 2, 4), wonderful.createdDate());
        assertEquals(PrecureColor.PINK, wonderful.color());
        assertEquals("5/13", wonderful.birthday());
        assertEquals("ワンダフルパクト！\n" +
                "プリキュア！マイエボリューション！\n" +
                "スリー！\n" +
                "ツー！\n" +
                "ワン！\n" +
                "みんな大好き素敵な世界！\n" +
                "キュアワンダフル！\n" +
                "いっしょに遊ぼ♪\n" +
                "せーの！\n" +
                "わんだふるぷりきゅあ！",
                wonderful.getTransformMessage());
        assertEquals(0, wonderful.getExtraNames().size());
        assertEquals(1, wonderful.getAttackMessages().size());
        assertEquals("フレンドリータクト！\n" +
                "ワンダフルをきみに！\n" +
                "ワン！ワン！わ〜ん！\n" +
                "ガルガルな心、飛んでけー！！\n" +
                "プリキュア！フレンドリベラーレ！",
                wonderful.getAttackMessages().get(0));
        assertEquals(List.of("my_evolution"), wonderful.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(wonderful, Girl.byName("wonderful"));
    }

    @Test
    void 変身() {
        wonderful.humanize();

        assertEquals("犬飼こむぎ", wonderful.name());
        wonderful.transform();
        assertEquals(List.of("ワンダフルパクト！",
                "プリキュア！マイエボリューション！",
                "スリー！",
                "ツー！",
                "ワン！",
                "みんな大好き素敵な世界！",
                "キュアワンダフル！",
                "いっしょに遊ぼ♪",
                "せーの！",
                "わんだふるぷりきゅあ！"),
                messageTester.messages);
        assertEquals("キュアワンダフル", wonderful.name());

        messageTester.messages.clear();
        wonderful.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("犬飼こむぎ", wonderful.name());

        messageTester.messages.clear();
        wonderful.myEvolution();
        assertEquals(List.of("ワンダフルパクト！",
                "プリキュア！マイエボリューション！",
                "スリー！",
                "ツー！",
                "ワン！",
                "みんな大好き素敵な世界！",
                "キュアワンダフル！",
                "いっしょに遊ぼ♪",
                "せーの！",
                "わんだふるぷりきゅあ！"),
                messageTester.messages);
        assertEquals("キュアワンダフル", wonderful.name());

        messageTester.messages.clear();
        wonderful.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("犬飼こむぎ", wonderful.name());
    }

    @Test
    void 攻撃(){
        wonderful.humanize();
        assertThrows(RequireTransformException.class, () -> wonderful.attack(), "Require transform.");

        wonderful.transform();
        messageTester.messages.clear();
        wonderful.attack();
        assertEquals(List.of("フレンドリータクト！",
                "ワンダフルをきみに！",
                "ワン！ワン！わ〜ん！",
                "ガルガルな心、飛んでけー！！",
                "プリキュア！フレンドリベラーレ！"),
                messageTester.messages);
    }
}