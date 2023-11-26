package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureWingTest extends GirlTestBase {

    CureWing wing = Cure.wing;

    @Test
    void 基本情報(){
        assertEquals("cure_wing", wing.girlName());
        assertEquals("夕凪ツバサ", wing.humanName());
        assertEquals("夕凪ツバサ", wing.fullName());
        assertEquals("Undefined.", wing.humanFullName());
        assertEquals("キュアウィング", wing.precureName());
        assertEquals("村瀬歩", wing.castName());
        assertEquals(LocalDate.of(2023, 4, 2), wing.createdDate());
        assertEquals(PrecureColor.ORANGE, wing.color());
        assertEquals("5/21", wing.birthday());
        assertEquals("""
                スカイミラージュ！
                トーンコネクト！
                ひろがるチェンジ！
                ウィング！
                きらめきHOP
                さわやかSTEP
                はればれJUMP
                天高くひろがる勇気！キュアウィング！
                Ready…Go!
                ひろがるスカイ！プリキュア！""",
                wing.getTransformMessage());
        assertEquals(0, wing.getExtraNames().size());
        assertEquals(1, wing.getAttackMessages().size());
        assertEquals("ひろがる！ウィングアタック！",
                wing.getAttackMessages().get(0));
        assertEquals(List.of("sky_mirage_tone_connect"), wing.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(wing, Girl.byName("wing"));
    }

    @Test
    void 変身() {
        wing.humanize();

        assertEquals("夕凪ツバサ", wing.name());
        wing.transform();
        assertEquals(List.of("スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "ウィング！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "天高くひろがる勇気！キュアウィング！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアウィング", wing.name());

        messageTester.messages.clear();
        wing.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夕凪ツバサ", wing.name());

        messageTester.messages.clear();
        wing.skyMirageToneConnect();
        assertEquals(List.of("スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "ウィング！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "天高くひろがる勇気！キュアウィング！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアウィング", wing.name());

        messageTester.messages.clear();
        wing.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夕凪ツバサ", wing.name());
    }

    @Test
    void 攻撃(){
        wing.humanize();
        assertThrows(RequireTransformException.class, () -> wing.attack(), "Require transform.");

        wing.transform();
        messageTester.messages.clear();
        wing.attack();
        assertEquals(List.of("ひろがる！ウィングアタック！"),
                messageTester.messages);
    }
}
