package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureSwordTest extends GirlTestBase {

    CureSword sword = Cure.sword;

    @Test
    void 基本情報(){
        assertEquals("cure_sword", sword.girlName());
        assertEquals("剣崎真琴", sword.humanName());
        assertEquals("剣崎真琴", sword.fullName());
        assertEquals("Undefined.", sword.humanFullName());
        assertEquals("キュアソード", sword.precureName());
        assertEquals("宮本佳那子", sword.castName());
        assertEquals(LocalDate.of(2013, 2, 3), sword.createdDate());
        assertEquals(PrecureColor.PURPLE, sword.color());
        assertEquals("11/4", sword.birthday());
        assertEquals("プリキュアラブリンク！\n" +
                "L! O! V! E!\n" +
                "勇気の刃！ キュアソード！\n" +
                "響け愛の鼓動！ドキドキプリキュア！\n" +
                "このキュアソードが愛の剣で\n" +
                "あなたの野望を断ち切ってみせる！",
                sword.getTransformMessage());
        assertEquals(0, sword.getExtraNames().size());
        assertEquals(1, sword.getAttackMessages().size());
        assertEquals("ひらめけ！ホーリーソード！",
                sword.getAttackMessages().get(0));
        assertEquals(List.of("love_link"),
                            sword.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(sword, Girl.byName("sword"));
    }

    @Test
    void 変身(){
        sword.humanize();

        assertEquals("剣崎真琴", sword.name());
        sword.transform();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "勇気の刃！ キュアソード！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "このキュアソードが愛の剣で",
                "あなたの野望を断ち切ってみせる！"),
                messageTester.messages);
        assertEquals("キュアソード", sword.name());

        messageTester.messages.clear();
        sword.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("剣崎真琴", sword.name());

        messageTester.messages.clear();
        sword.loveLink();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "勇気の刃！ キュアソード！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "このキュアソードが愛の剣で",
                "あなたの野望を断ち切ってみせる！"),
                messageTester.messages);
        assertEquals("キュアソード", sword.name());

        messageTester.messages.clear();
        sword.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("剣崎真琴", sword.name());
    }

    @Test
    void 攻撃(){
        sword.humanize();
        assertThrows(RequireTransformException.class, () -> sword.attack(), "Require transform.");

        sword.transform();
        messageTester.messages.clear();
        sword.attack();
        assertEquals(List.of("ひらめけ！ホーリーソード！"),
                messageTester.messages);

    }
}
