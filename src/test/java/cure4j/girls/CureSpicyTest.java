package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureSpicyTest extends GirlTestBase {

    CureSpicy spicy = Cure.spicy;

    @Test
    void 基本情報(){
        assertEquals("cure_spicy", spicy.girlName());
        assertEquals("芙羽ここね", spicy.humanName());
        assertEquals("芙羽ここね", spicy.fullName());
        assertEquals("Undefined.", spicy.humanFullName());
        assertEquals("キュアスパイシー", spicy.precureName());
        assertEquals("清水理沙", spicy.castName());
//        assertEquals(LocalDate.of(2022, 2, 6), spicy.createdDate());
        assertEquals(PrecureColor.BLUE, spicy.color());
//        assertTrue(spicy.hasBirthday());
//        assertEquals("3/9", spicy.birthday());
//        assertEquals("\n" +
//                "\n" +
//                "",
//                spicy.getTransformMessage());
        assertEquals(0, spicy.getExtraNames().size());
//        assertEquals(1, spicy.getAttackMessages().size());
//        assertEquals(TestUtil.waveDash2FullwidthTilde(
//                "\n" +
//                "\n" +
//                ""),
//                spicy.getAttackMessages().get(0));
//        assertEquals(List.of("precure_operation"),
//                            spicy.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(spicy, Girl.byName("spicy"));
    }

    @Test
    void 変身(){
        spicy.humanize();

        assertEquals("芙羽ここね", spicy.name());
        spicy.transform();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
        assertEquals("キュアスパイシー", spicy.name());

        messageTester.messages.clear();
        spicy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("芙羽ここね", spicy.name());

        messageTester.messages.clear();
//        spicy.xxxx();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
//        assertEquals("キュアスパイシー", spicy.name());

        messageTester.messages.clear();
        spicy.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("芙羽ここね", spicy.name());
    }

    @Test
    void 攻撃(){
        spicy.humanize();
        assertThrows(RequireTransformException.class, () -> spicy.attack(), "Require transform.");

        spicy.transform();
        messageTester.messages.clear();
        spicy.attack();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
    }
}
