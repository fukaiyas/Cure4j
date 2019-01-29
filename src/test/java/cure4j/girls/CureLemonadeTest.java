package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureLemonadeTest extends GirlTestBase {

    CureLemonade lemonade = Cure.lemonade;

    @Test
    void 基本情報(){
        assertEquals("cure_lemonade", lemonade.girlName());
        assertEquals("春日野うらら", lemonade.humanName());
        assertEquals("春日野うらら", lemonade.fullName());
        assertEquals("Undefined.", lemonade.humanFullName());
        assertEquals("キュアレモネード", lemonade.precureName());
        assertEquals("伊瀬茉莉也", lemonade.castName());
        assertEquals(LocalDate.of(2007, 2, 18), lemonade.createdDate());
        assertEquals(PrecureColor.YELLOW, lemonade.color());
        assertFalse(lemonade.hasBirthday());
        assertEquals("プリキュア！メタモルフォーゼ！\n" +
                        "はじけるレモンの香り、キュアレモネード！\n" +
                        "希望の力と未来の光！\n" +
                        "華麗に羽ばたく5つの心！\n" +
                        "Yes！プリキュア5！",
                        lemonade.getTransformMessage());
        assertEquals(0, lemonade.getExtraNames().size());
        assertEquals(1, lemonade.getAttackMessages().size());
        assertEquals("輝く乙女のはじける力、受けてみなさい！\n" +
                        "プリキュア！プリズム・チェーン！",
                lemonade.getAttackMessages().get(0));
        assertEquals(List.of("metamorphose"), lemonade.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(lemonade, Girl.byName("lemonade"));
    }

    @Test
    void 変身() {
        lemonade.humanize();

        assertEquals("春日野うらら", lemonade.name());
        lemonade.transform();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "はじけるレモンの香り、キュアレモネード！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアレモネード", lemonade.name());

        messageTester.messages.clear();
        lemonade.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("春日野うらら", lemonade.name());

        messageTester.messages.clear();
        lemonade.metamorphose();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "はじけるレモンの香り、キュアレモネード！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアレモネード", lemonade.name());

        messageTester.messages.clear();
        lemonade.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("春日野うらら", lemonade.name());
    }

    @Test
    void 攻撃(){
        lemonade.humanize();
        assertThrows(RequireTransformException.class, () -> lemonade.attack(), "Require transform.");

        lemonade.transform();
        messageTester.messages.clear();
        lemonade.attack();
        assertEquals(List.of("輝く乙女のはじける力、受けてみなさい！",
                        "プリキュア！プリズム・チェーン！"),
                messageTester.messages);
    }
}
