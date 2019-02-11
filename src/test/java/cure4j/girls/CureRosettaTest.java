package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureRosettaTest extends GirlTestBase {

    CureRosetta rosetta = Cure.rosetta;

    @Test
    void 基本情報(){
        assertEquals("cure_rosetta", rosetta.girlName());
        assertEquals("四葉ありす", rosetta.humanName());
        assertEquals("四葉ありす", rosetta.fullName());
        assertEquals("Undefined.", rosetta.humanFullName());
        assertEquals("キュアロゼッタ", rosetta.precureName());
        assertEquals("渕上舞", rosetta.castName());
        assertEquals(LocalDate.of(2013, 2, 24), rosetta.createdDate());
        assertEquals(PrecureColor.YELLOW, rosetta.color());
        assertEquals("5/28", rosetta.birthday());
        assertEquals("プリキュアラブリンク！\n" +
                "L! O! V! E!\n" +
                "ひだまりポカポカ キュアロゼッタ！\n" +
                "響け愛の鼓動！ドキドキプリキュア！\n" +
                "世界を制するのは愛だけです、\n" +
                "さぁ、あなたも私と愛を育んでくださいな",
                rosetta.getTransformMessage());
        assertEquals(0, rosetta.getExtraNames().size());
        assertEquals(1, rosetta.getAttackMessages().size());
        assertEquals("カッチカチの！ロゼッタウォール！",
                rosetta.getAttackMessages().get(0));
        assertEquals(List.of("love_link"),
                            rosetta.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(rosetta, Girl.byName("rosetta"));
    }

    @Test
    void 変身(){
        rosetta.humanize();

        assertEquals("四葉ありす", rosetta.name());
        rosetta.transform();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "ひだまりポカポカ キュアロゼッタ！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "世界を制するのは愛だけです、",
                "さぁ、あなたも私と愛を育んでくださいな"),
                messageTester.messages);
        assertEquals("キュアロゼッタ", rosetta.name());

        messageTester.messages.clear();
        rosetta.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("四葉ありす", rosetta.name());

        messageTester.messages.clear();
        rosetta.loveLink();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "ひだまりポカポカ キュアロゼッタ！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "世界を制するのは愛だけです、",
                "さぁ、あなたも私と愛を育んでくださいな"),
                messageTester.messages);
        assertEquals("キュアロゼッタ", rosetta.name());

        messageTester.messages.clear();
        rosetta.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("四葉ありす", rosetta.name());
    }

    @Test
    void 攻撃(){
        rosetta.humanize();
        assertThrows(RequireTransformException.class, () -> rosetta.attack(), "Require transform.");

        rosetta.transform();
        messageTester.messages.clear();
        rosetta.attack();
        assertEquals(List.of("カッチカチの！ロゼッタウォール！"),
                messageTester.messages);

    }
}
