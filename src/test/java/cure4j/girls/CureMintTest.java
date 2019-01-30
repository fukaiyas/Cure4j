package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureMintTest extends GirlTestBase {

    CureMint mint = Cure.mint;

    @Test
    void 基本情報(){
        assertEquals("cure_mint", mint.girlName());
        assertEquals("秋元こまち", mint.humanName());
        assertEquals("秋元こまち", mint.fullName());
        assertEquals("Undefined.", mint.humanFullName());
        assertEquals("キュアミント", mint.precureName());
        assertEquals("永野愛", mint.castName());
        assertEquals(LocalDate.of(2007, 2, 25), mint.createdDate());
        assertEquals(PrecureColor.GREEN, mint.color());
        assertFalse(mint.hasBirthday());
        assertEquals("プリキュア！メタモルフォーゼ！\n" +
                        "安らぎの緑の大地、キュアミント！\n" +
                        "希望の力と未来の光！\n" +
                        "華麗に羽ばたく5つの心！\n" +
                        "Yes！プリキュア5！",
                        mint.getTransformMessage());
        assertEquals(0, mint.getExtraNames().size());
        assertEquals(1, mint.getAttackMessages().size());
        assertEquals("大地を揺るがす乙女の怒り、受けてみなさい！\n" +
                        "プリキュア！エメラルド・ソーサー！",
                mint.getAttackMessages().get(0));
        assertEquals(List.of("metamorphose"), mint.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(mint, Girl.byName("mint"));
    }

    @Test
    void 変身() {
        mint.humanize();

        assertEquals("秋元こまち", mint.name());
        mint.transform();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "安らぎの緑の大地、キュアミント！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアミント", mint.name());

        messageTester.messages.clear();
        mint.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("秋元こまち", mint.name());

        messageTester.messages.clear();
        mint.metamorphose();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "安らぎの緑の大地、キュアミント！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアミント", mint.name());

        messageTester.messages.clear();
        mint.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("秋元こまち", mint.name());
    }

    @Test
    void 攻撃(){
        mint.humanize();
        assertThrows(RequireTransformException.class, () -> mint.attack(), "Require transform.");

        mint.transform();
        messageTester.messages.clear();
        mint.attack();
        assertEquals(List.of("大地を揺るがす乙女の怒り、受けてみなさい！",
                        "プリキュア！エメラルド・ソーサー！"),
                messageTester.messages);
    }
}
