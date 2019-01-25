package cure4j.girls;

import cure4j.Cure4j.Shiny;
import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShinyLuminousTest extends GirlTestBase{

    ShinyLuminous luminous = Shiny.luminous;

    @Test
    void 基本情報(){
        assertEquals("shiny_luminous", luminous.girlName);
        assertEquals("九条ひかり", luminous.humanName());
        assertEquals("九条ひかり", luminous.fullName());
        assertEquals("Undefined.", luminous.humanFullName());
        assertEquals("シャイニールミナス", luminous.precureName());
        assertEquals("田中理恵", luminous.castName());
        assertEquals(LocalDate.of(2005, 3, 6), luminous.createdDate());
        assertEquals(PrecureColor.YELLOW, luminous.color());
        assertTrue(luminous.hasBirthday());
        assertEquals("9/9", luminous.birthday());
        assertEquals("ルミナス・シャイニングストリーム！\n" +
                "輝く命、シャイニールミナス！\n" +
                "光の心と光の意志、すべてを一つにするために！",
                luminous.getTransformMessage());
        assertEquals(0, luminous.getExtraNames().size());
        assertEquals(1, luminous.getAttackMessages().size());
        assertEquals("光の意志よ！私に勇気を！希望と力を！！\n" +
                "ルミナス・ハーティエル・アンクション！",
                luminous.getAttackMessages().get(0));
        assertEquals(1, luminous.getTransformCalls().size());
        assertEquals("shining_stream", luminous.getTransformCalls().get(0));
    }

    @Test
    void エイリアス(){
        assertEquals(luminous, Girl.byName("luminous"));
    }

    @Test
    void 変身(){
        luminous.humanize();

        assertEquals("九条ひかり", luminous.name());
        luminous.transform();
        assertEquals(List.of("ルミナス・シャイニングストリーム！",
                "輝く命、シャイニールミナス！",
                "光の心と光の意志、すべてを一つにするために！"),
                messageTester.messages);
        assertEquals("シャイニールミナス", luminous.name());

        messageTester.messages.clear();
        luminous.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("九条ひかり", luminous.name());

        messageTester.messages.clear();
        luminous.shiningStream();
        assertEquals(List.of("ルミナス・シャイニングストリーム！",
                "輝く命、シャイニールミナス！",
                "光の心と光の意志、すべてを一つにするために！"),
                messageTester.messages);
        assertEquals("シャイニールミナス", luminous.name());

        messageTester.messages.clear();
        luminous.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("九条ひかり", luminous.name());
    }

    @Test
    void 攻撃(){
        luminous.humanize();
        assertThrows(RequireTransformException.class, () -> luminous.attack(), "Require transform.");

        luminous.transform();
        messageTester.messages.clear();
        luminous.attack();
        assertEquals(List.of("光の意志よ！私に勇気を！希望と力を！！",
                "ルミナス・ハーティエル・アンクション！"),
                messageTester.messages);
    }
}
