package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureLillianTest extends GirlTestBase {

    CureLillian lillian = Cure.lillian;

    @Test
    void 基本情報(){
        assertEquals("cure_lillian", lillian.girlName());
        assertEquals("猫屋敷まゆ", lillian.humanName());
        assertEquals("猫屋敷まゆ", lillian.fullName());
        assertEquals("Undefined.", lillian.humanFullName());
        assertEquals("キュアリリアン", lillian.precureName());
        assertEquals("上田麗奈", lillian.castName());
        assertEquals(LocalDate.of(2024, 6, 9), lillian.createdDate());
        assertEquals(PrecureColor.GREEN, lillian.color());
        assertEquals("11/5", lillian.birthday());
        assertEquals("シャイニーキャッツパクト！\n" +
                "プリキュア！マイエボリューション！\n" +
                "目元にきらめき！\n" +
                "リップはキュートに！\n" +
                "結んで紡いでつながる世界！\n" +
                "キュアリリアン！\n" +
                "こわくない、こわくない\n" +
                "ニャンダフルプリキュア！",
                lillian.getTransformMessage());
        assertEquals(0, lillian.getExtraNames().size());
        assertEquals(1, lillian.getAttackMessages().size());
        assertEquals("アミティーリボンタンバリン！\n" +
                "ニャンダフルをあなたに！\n" +
                "ニャン！ドゥ！トロワ！\n" +
                "ガルガルの心さようなら！\n" +
                "プリキュア！アミティールミエール！",
                lillian.getAttackMessages().get(0));
        assertEquals(List.of("my_evolution"), lillian.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(lillian, Girl.byName("lillian"));
    }

    @Test
    void 変身() {
        lillian.humanize();

        assertEquals("猫屋敷まゆ", lillian.name());
        lillian.transform();
        assertEquals(List.of("シャイニーキャッツパクト！",
                "プリキュア！マイエボリューション！",
                "目元にきらめき！",
                "リップはキュートに！",
                "結んで紡いでつながる世界！",
                "キュアリリアン！",
                "こわくない、こわくない",
                "ニャンダフルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアリリアン", lillian.name());

        messageTester.messages.clear();
        lillian.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("猫屋敷まゆ", lillian.name());

        messageTester.messages.clear();
        lillian.myEvolution();
        assertEquals(List.of("シャイニーキャッツパクト！",
                "プリキュア！マイエボリューション！",
                "目元にきらめき！",
                "リップはキュートに！",
                "結んで紡いでつながる世界！",
                "キュアリリアン！",
                "こわくない、こわくない",
                "ニャンダフルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアリリアン", lillian.name());

        messageTester.messages.clear();
        lillian.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("猫屋敷まゆ", lillian.name());
    }

    @Test
    void 攻撃(){
        lillian.humanize();
        assertThrows(RequireTransformException.class, () -> lillian.attack(), "Require transform.");

        lillian.transform();
        messageTester.messages.clear();
        lillian.attack();
        assertEquals(List.of("アミティーリボンタンバリン！",
                "ニャンダフルをあなたに！",
                "ニャン！ドゥ！トロワ！",
                "ガルガルの心さようなら！",
                "プリキュア！アミティールミエール！"),
                messageTester.messages);
    }
}