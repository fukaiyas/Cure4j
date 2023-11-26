package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureButterflyTest extends GirlTestBase {

    CureButterfly butterfly = Cure.butterfly;

    @Test
    void 基本情報(){
        assertEquals("cure_butterfly", butterfly.girlName());
        assertEquals("聖あげは", butterfly.humanName());
        assertEquals("聖あげは", butterfly.fullName());
        assertEquals("Undefined.", butterfly.humanFullName());
        assertEquals("キュアバタフライ", butterfly.precureName());
        assertEquals("七瀬彩夏", butterfly.castName());
        assertEquals(LocalDate.of(2023, 6, 4), butterfly.createdDate());
        assertEquals(PrecureColor.PINK, butterfly.color());
        assertEquals("8/8", butterfly.birthday());
        assertEquals("""
                スカイミラージュ！
                トーンコネクト！
                ひろがるチェンジ！
                バタフライ！
                きらめきHOP
                さわやかSTEP
                はればれJUMP
                アゲてひろがるワンダホー！キュアバタフライ！
                Ready…Go!
                ひろがるスカイ！プリキュア！""",
                butterfly.getTransformMessage());
        assertEquals(0, butterfly.getExtraNames().size());
        assertEquals(1, butterfly.getAttackMessages().size());
        assertEquals("ひろがる！バタフライプレス！",
                butterfly.getAttackMessages().get(0));
        assertEquals(List.of("sky_mirage_tone_connect"), butterfly.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(butterfly, Girl.byName("butterfly"));
    }

    @Test
    void 変身() {
        butterfly.humanize();

        assertEquals("聖あげは", butterfly.name());
        butterfly.transform();
        assertEquals(List.of("スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "バタフライ！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "アゲてひろがるワンダホー！キュアバタフライ！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアバタフライ", butterfly.name());

        messageTester.messages.clear();
        butterfly.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("聖あげは", butterfly.name());

        messageTester.messages.clear();
        butterfly.skyMirageToneConnect();
        assertEquals(List.of("スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "バタフライ！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "アゲてひろがるワンダホー！キュアバタフライ！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアバタフライ", butterfly.name());

        messageTester.messages.clear();
        butterfly.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("聖あげは", butterfly.name());
    }

    @Test
    void 攻撃(){
        butterfly.humanize();
        assertThrows(RequireTransformException.class, () -> butterfly.attack(), "Require transform.");

        butterfly.transform();
        messageTester.messages.clear();
        butterfly.attack();
        assertEquals(List.of("ひろがる！バタフライプレス！"),
                messageTester.messages);
    }
}
