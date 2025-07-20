package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureNyammyTest extends GirlTestBase {

    CureNyammy nyammy = Cure.nyammy;

    @Test
    void 基本情報(){
        assertEquals("cure_nyammy", nyammy.girlName());
        assertEquals("猫屋敷ユキ", nyammy.humanName());
        assertEquals("猫屋敷ユキ", nyammy.fullName());
        assertEquals("Undefined.", nyammy.humanFullName());
        assertEquals("キュアニャミー", nyammy.precureName());
        assertEquals("松田颯水", nyammy.castName());
        assertEquals(LocalDate.of(2024, 5, 26), nyammy.createdDate());
        assertEquals(PrecureColor.BLUE, nyammy.color());
        assertEquals("12/21", nyammy.birthday());
        assertEquals("シャイニーキャッツパクト！\n" +
                "プリキュア！マイエボリューション！\n" +
                "ほっぺにきらめき！\n" +
                "リップはキュートに！\n" +
                "気高くかわいくきらめく世界！\n" +
                "キュアニャミー！\n" +
                "仕方ない、構ってあげる\n" +
                "ニャンダフルプリキュア！",
                nyammy.getTransformMessage());
        assertEquals(0, nyammy.getExtraNames().size());
        assertEquals(1, nyammy.getAttackMessages().size());
        assertEquals("アミティーリボンタンバリン！\n" +
                "ニャンダフルをあなたに！\n" +
                "ニャン！ドゥ！トロワ！\n" +
                "ガルガルの心さようなら！\n" +
                "プリキュア！アミティールミエール！",
                nyammy.getAttackMessages().get(0));
        assertEquals(List.of("my_evolution"), nyammy.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(nyammy, Girl.byName("nyammy"));
    }

    @Test
    void 変身() {
        nyammy.humanize();

        assertEquals("猫屋敷ユキ", nyammy.name());
        nyammy.transform();
        assertEquals(List.of("シャイニーキャッツパクト！",
                "プリキュア！マイエボリューション！",
                "ほっぺにきらめき！",
                "リップはキュートに！",
                "気高くかわいくきらめく世界！",
                "キュアニャミー！",
                "仕方ない、構ってあげる",
                "ニャンダフルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアニャミー", nyammy.name());

        messageTester.messages.clear();
        nyammy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("猫屋敷ユキ", nyammy.name());

        messageTester.messages.clear();
        nyammy.myEvolution();
        assertEquals(List.of("シャイニーキャッツパクト！",
                "プリキュア！マイエボリューション！",
                "ほっぺにきらめき！",
                "リップはキュートに！",
                "気高くかわいくきらめく世界！",
                "キュアニャミー！",
                "仕方ない、構ってあげる",
                "ニャンダフルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアニャミー", nyammy.name());

        messageTester.messages.clear();
        nyammy.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("猫屋敷ユキ", nyammy.name());
    }

    @Test
    void 攻撃(){
        nyammy.humanize();
        assertThrows(RequireTransformException.class, () -> nyammy.attack(), "Require transform.");

        nyammy.transform();
        messageTester.messages.clear();
        nyammy.attack();
        assertEquals(List.of("アミティーリボンタンバリン！",
                "ニャンダフルをあなたに！",
                "ニャン！ドゥ！トロワ！",
                "ガルガルの心さようなら！",
                "プリキュア！アミティールミエール！"),
                messageTester.messages);
    }
}