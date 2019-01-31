package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureAquaTest extends GirlTestBase {

    CureAqua aqua = Cure.aqua;

    @Test
    void 基本情報(){
        assertEquals("cure_aqua", aqua.girlName());
        assertEquals("水無月かれん", aqua.humanName());
        assertEquals("水無月かれん", aqua.fullName());
        assertEquals("Undefined.", aqua.humanFullName());
        assertEquals("キュアアクア", aqua.precureName());
        assertEquals("前田愛", aqua.castName());
        assertEquals(LocalDate.of(2007, 3, 11), aqua.createdDate());
        assertEquals(PrecureColor.BLUE, aqua.color());
        assertFalse(aqua.hasBirthday());
        assertEquals("プリキュア！メタモルフォーゼ！\n" +
                        "知性の青き泉、キュアアクア！\n" +
                        "希望の力と未来の光！\n" +
                        "華麗に羽ばたく5つの心！\n" +
                        "Yes！プリキュア5！",
                        aqua.getTransformMessage());
        assertEquals(0, aqua.getExtraNames().size());
        assertEquals(1, aqua.getAttackMessages().size());
        assertEquals("岩をも砕く乙女の激流、受けてみなさい！\n" +
                        "プリキュア！サファイヤ・アロー！",//TODO サファイア？
                aqua.getAttackMessages().get(0));
        assertEquals(List.of("metamorphose"), aqua.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(aqua, Girl.byName("aqua"));
    }

    @Test
    void 変身() {
        aqua.humanize();

        assertEquals("水無月かれん", aqua.name());
        aqua.transform();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "知性の青き泉、キュアアクア！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアアクア", aqua.name());

        messageTester.messages.clear();
        aqua.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("水無月かれん", aqua.name());

        messageTester.messages.clear();
        aqua.metamorphose();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "知性の青き泉、キュアアクア！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアアクア", aqua.name());

        messageTester.messages.clear();
        aqua.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("水無月かれん", aqua.name());
    }

    @Test
    void 攻撃(){
        aqua.humanize();
        assertThrows(RequireTransformException.class, () -> aqua.attack(), "Require transform.");

        aqua.transform();
        messageTester.messages.clear();
        aqua.attack();
        assertEquals(List.of("岩をも砕く乙女の激流、受けてみなさい！",
                        "プリキュア！サファイヤ・アロー！"),
                messageTester.messages);
    }
}
