package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureDiamondTest extends GirlTestBase {

    CureDiamond diamond = Cure.diamond;

    @Test
    void 基本情報(){
        assertEquals("cure_diamond", diamond.girlName());
        assertEquals("菱川六花", diamond.humanName());
        assertEquals("菱川六花", diamond.fullName());
        assertEquals("Undefined.", diamond.humanFullName());
        assertEquals("キュアダイヤモンド", diamond.precureName());
        assertEquals("寿美菜子", diamond.castName());
        assertEquals(LocalDate.of(2013, 2, 17), diamond.createdDate());
        assertEquals(PrecureColor.BLUE, diamond.color());
        assertEquals("9/17", diamond.birthday());
        assertEquals("プリキュアラブリンク！\n" +
                "L! O! V! E!\n" +
                "英知の光！ キュアダイヤモンド！\n" +
                "響け愛の鼓動！ドキドキプリキュア！\n" +
                "人の思いを踏みにじるなんて許せない、\n" +
                "このキュアダイヤモンドがあなたの頭を冷やしてあげる！",
                diamond.getTransformMessage());
        assertEquals(0, diamond.getExtraNames().size());
        assertEquals(1, diamond.getAttackMessages().size());
        assertEquals("きらめきなさい！トゥインクルダイヤモンド！",
                diamond.getAttackMessages().get(0));
        assertEquals(List.of("love_link"),
                            diamond.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(diamond, Girl.byName("diamond"));
    }

    @Test
    void 変身(){
        diamond.humanize();

        assertEquals("菱川六花", diamond.name());
        diamond.transform();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "英知の光！ キュアダイヤモンド！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "人の思いを踏みにじるなんて許せない、",
                "このキュアダイヤモンドがあなたの頭を冷やしてあげる！"),
                messageTester.messages);
        assertEquals("キュアダイヤモンド", diamond.name());

        messageTester.messages.clear();
        diamond.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("菱川六花", diamond.name());

        messageTester.messages.clear();
        diamond.loveLink();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "英知の光！ キュアダイヤモンド！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "人の思いを踏みにじるなんて許せない、",
                "このキュアダイヤモンドがあなたの頭を冷やしてあげる！"),
                messageTester.messages);
        assertEquals("キュアダイヤモンド", diamond.name());

        messageTester.messages.clear();
        diamond.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("菱川六花", diamond.name());
    }

    @Test
    void 攻撃(){
        diamond.humanize();
        assertThrows(RequireTransformException.class, () -> diamond.attack(), "Require transform.");

        diamond.transform();
        messageTester.messages.clear();
        diamond.attack();
        assertEquals(List.of("きらめきなさい！トゥインクルダイヤモンド！"),
                messageTester.messages);
    }
}
