package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureEtoileTest extends GirlTestBase {

    CureEtoile etoile = Cure.etoile;

    @Test
    void 基本情報(){
        assertEquals("cure_etoile", etoile.girlName());
        assertEquals("輝木ほまれ", etoile.humanName());
        assertEquals("輝木ほまれ", etoile.fullName());
        assertEquals("Undefined.", etoile.humanFullName());
        assertEquals("キュアエトワール", etoile.precureName());
        assertEquals("小倉唯", etoile.castName());
        assertEquals(LocalDate.of(2018, 3, 4), etoile.createdDate());
        assertEquals(PrecureColor.YELLOW, etoile.color());
        assertEquals("4/8", etoile.birthday());
        assertEquals("ミライクリスタル！\n" +
                "ハートキラっと！\n" +
                "は～ぎゅ～～！\n" +
                "ぎゅ～！\n" +
                "ぎゅ～～！\n" +
                "輝く未来を抱きしめて！\n" +
                "みんな輝け！力のプリキュア！キュアエトワール！",
                etoile.getTransformMessage());
        assertEquals(0, etoile.getExtraNames().size());
        assertEquals(1, etoile.getAttackMessages().size());
        assertEquals("フレフレ！ハート・スター！",
                etoile.getAttackMessages().get(0));
        assertEquals(List.of("heart_kiratto"), etoile.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(etoile, Girl.byName("etoile"));
    }

    @Test
    void 変身() {
        etoile.humanize();

        assertEquals("輝木ほまれ", etoile.name());
        etoile.transform();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんな輝け！力のプリキュア！キュアエトワール！"),
                messageTester.messages);
        assertEquals("キュアエトワール", etoile.name());

        messageTester.messages.clear();
        etoile.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("輝木ほまれ", etoile.name());

        messageTester.messages.clear();
        etoile.heartKiratto();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんな輝け！力のプリキュア！キュアエトワール！"),
                messageTester.messages);
        assertEquals("キュアエトワール", etoile.name());

        messageTester.messages.clear();
        etoile.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("輝木ほまれ", etoile.name());
    }

    @Test
    void 攻撃(){
        etoile.humanize();
        assertThrows(RequireTransformException.class, () -> etoile.attack(), "Require transform.");

        etoile.transform();
        messageTester.messages.clear();
        etoile.attack();
        assertEquals(List.of("フレフレ！ハート・スター！"),
                messageTester.messages);
    }
}
