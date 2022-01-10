package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CurePreciousTest extends GirlTestBase {

    CurePrecious precious = Cure.precious;

    @Test
    void 基本情報(){
        assertEquals("cure_precious", precious.girlName());
        assertEquals("和実ゆい", precious.humanName());
        assertEquals("和実ゆい", precious.fullName());
        assertEquals("Undefined.", precious.humanFullName());
        assertEquals("キュアプレシャス", precious.precureName());
        assertEquals("菱川花菜", precious.castName());
        assertEquals(LocalDate.of(2022, 2, 6), precious.createdDate());
        assertEquals(PrecureColor.PINK, precious.color());
//        assertTrue(precious.hasBirthday());
//        assertEquals("3/9", precious.birthday());
//        assertEquals("\n" +
//                "\n" +
//                "",
//                precious.getTransformMessage());
        assertEquals(0, precious.getExtraNames().size());
//        assertEquals(1, precious.getAttackMessages().size());
//        assertEquals(TestUtil.waveDash2FullwidthTilde(
//                "\n" +
//                "\n" +
//                ""),
//                precious.getAttackMessages().get(0));
//        assertEquals(List.of("precure_operation"),
//                            precious.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(precious, Girl.byName("precious"));
    }

    @Test
    void 変身(){
        precious.humanize();

        assertEquals("和実ゆい", precious.name());
        precious.transform();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
        assertEquals("キュアプレシャス", precious.name());

        messageTester.messages.clear();
        precious.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("和実ゆい", precious.name());

        messageTester.messages.clear();
//        precious.xxxx();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
//        assertEquals("キュアプレシャス", precious.name());

        messageTester.messages.clear();
        precious.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("和実ゆい", precious.name());
    }

    @Test
    void 攻撃(){
        precious.humanize();
        assertThrows(RequireTransformException.class, () -> precious.attack(), "Require transform.");

        precious.transform();
        messageTester.messages.clear();
        precious.attack();
//        assertEquals(List.of("",
//                "",
//                ""),
//                messageTester.messages);
    }
}
