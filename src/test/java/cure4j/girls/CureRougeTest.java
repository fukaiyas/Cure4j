package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureRougeTest extends GirlTestBase {

    CureRouge rouge = Cure.rouge;

    @Test
    void 基本情報(){
        assertEquals("cure_rouge", rouge.girlName());
        assertEquals("夏木りん", rouge.humanName());
        assertEquals("夏木りん", rouge.fullName());
        assertEquals("Undefined.", rouge.humanFullName());
        assertEquals("キュアルージュ", rouge.precureName());
        assertEquals("竹内順子", rouge.castName());
        assertEquals(LocalDate.of(2007, 2, 11), rouge.createdDate());
        assertEquals(PrecureColor.RED, rouge.color());
        assertFalse(rouge.hasBirthday());
        assertEquals("プリキュア！メタモルフォーゼ！\n" +
                        "情熱の赤い炎、キュアルージュ！\n" +
                        "希望の力と未来の光！\n" +
                        "華麗に羽ばたく5つの心！\n" +
                        "Yes！プリキュア5！",
                        rouge.getTransformMessage());
        assertEquals(0, rouge.getExtraNames().size());
        assertEquals(1, rouge.getAttackMessages().size());
        assertEquals("純情乙女の炎の力、受けてみなさい！\n" +
                        "プリキュア！ファイヤー・ストライク！",
                rouge.getAttackMessages().get(0));
        assertEquals(List.of("metamorphose"), rouge.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(rouge, Girl.byName("rouge"));
    }

    @Test
    void 変身() {
        rouge.humanize();

        assertEquals("夏木りん", rouge.name());
        rouge.transform();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "情熱の赤い炎、キュアルージュ！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアルージュ", rouge.name());

        messageTester.messages.clear();
        rouge.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夏木りん", rouge.name());

        messageTester.messages.clear();
        rouge.metamorphose();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "情熱の赤い炎、キュアルージュ！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアルージュ", rouge.name());

        messageTester.messages.clear();
        rouge.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夏木りん", rouge.name());
    }

    @Test
    void 攻撃(){
        rouge.humanize();
        assertThrows(RequireTransformException.class, () -> rouge.attack(), "Require transform.");

        rouge.transform();
        messageTester.messages.clear();
        rouge.attack();
        assertEquals(List.of("純情乙女の炎の力、受けてみなさい！",
                        "プリキュア！ファイヤー・ストライク！"),
                messageTester.messages);
    }
}
