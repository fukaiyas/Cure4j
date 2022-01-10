package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureYumyumTest extends GirlTestBase {

    CureYumyum yumyum = Cure.yumyum;

    @Test
    void 基本情報(){
        assertEquals("cure_yumyum", yumyum.girlName());
        assertEquals("華満らん", yumyum.humanName());
        assertEquals("華満らん", yumyum.fullName());
        assertEquals("Undefined.", yumyum.humanFullName());
        assertEquals("キュアヤムヤム", yumyum.precureName());
        assertEquals("井口裕香", yumyum.castName());
//        assertEquals(LocalDate.of(2022, 2, 6), yumyum.createdDate());
        assertEquals(PrecureColor.YELLOW, yumyum.color());
//        assertTrue(yumyum.hasBirthday());
//        assertEquals("3/9", yumyum.birthday());
//        assertEquals("\n" +
//                "\n" +
//                "",
//                yumyum.getTransformMessage());
        assertEquals(0, yumyum.getExtraNames().size());
//        assertEquals(1, yumyum.getAttackMessages().size());
//        assertEquals(TestUtil.waveDash2FullwidthTilde(
//                "\n" +
//                "\n" +
//                ""),
//                yumyum.getAttackMessages().get(0));
//        assertEquals(List.of("precure_operation"),
//                            yumyum.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(yumyum, Girl.byName("yumyum"));
    }

    @Test
    void 変身(){
        yumyum.humanize();

        assertEquals("華満らん", yumyum.name());
        yumyum.transform();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
        assertEquals("キュアヤムヤム", yumyum.name());

        messageTester.messages.clear();
        yumyum.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("華満らん", yumyum.name());

        messageTester.messages.clear();
//        yumyum.xxxx();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
//        assertEquals("キュアヤムヤム", yumyum.name());

        messageTester.messages.clear();
        yumyum.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("華満らん", yumyum.name());
    }

    @Test
    void 攻撃(){
        yumyum.humanize();
        assertThrows(RequireTransformException.class, () -> yumyum.attack(), "Require transform.");

        yumyum.transform();
        messageTester.messages.clear();
        yumyum.attack();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
    }
}
