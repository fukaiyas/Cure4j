package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureMajestyTest extends GirlTestBase {

    CureMajesty majesty = Cure.majesty;

    @Test
    void 基本情報(){
        assertEquals("cure_majesty", majesty.girlName());
        assertEquals("プリンセス・エル", majesty.humanName());
        assertEquals("プリンセス・エル", majesty.fullName());
        assertEquals("Undefined.", majesty.humanFullName());
        assertEquals("キュアマジェスティ", majesty.precureName());
        assertEquals("古賀葵", majesty.castName());
        assertEquals(LocalDate.of(2023, 9, 3), majesty.createdDate());
        assertEquals(PrecureColor.PURPLE, majesty.color());
        assertEquals("3/12", majesty.birthday());
        assertEquals("""
                スカイミラージュ！
                トーンコネクト！
                ひろがるチェンジ！
                マジェスティ！
                きらめきHOP
                さわやかSTEP
                はればれJUMP
                降り立つ気高き神秘！キュアマジェスティ！
                Ready…Go!
                ひろがるスカイ！プリキュア！""",
                majesty.getTransformMessage());
        assertEquals(0, majesty.getExtraNames().size());
        assertEquals(1, majesty.getAttackMessages().size());
        assertEquals("""
                マジェスティクルニクルン！
                ひろがる世界にテイクオフ！
                プリキュア！マジェスティックハレーション！""",
                majesty.getAttackMessages().get(0));
        assertEquals(List.of("sky_mirage_tone_connect"), majesty.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(majesty, Girl.byName("majesty"));
    }

    @Test
    void 変身() {
        majesty.humanize();

        assertEquals("プリンセス・エル", majesty.name());
        majesty.transform();
        assertEquals(List.of("スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "マジェスティ！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "降り立つ気高き神秘！キュアマジェスティ！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアマジェスティ", majesty.name());

        messageTester.messages.clear();
        majesty.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリンセス・エル", majesty.name());

        messageTester.messages.clear();
        majesty.skyMirageToneConnect();
        assertEquals(List.of("スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "マジェスティ！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "降り立つ気高き神秘！キュアマジェスティ！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアマジェスティ", majesty.name());

        messageTester.messages.clear();
        majesty.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリンセス・エル", majesty.name());
    }

    @Test
    void 攻撃(){
        majesty.humanize();
        assertThrows(RequireTransformException.class, () -> majesty.attack(), "Require transform.");

        majesty.transform();
        messageTester.messages.clear();
        majesty.attack();
        assertEquals(List.of(
                "マジェスティクルニクルン！",
                "ひろがる世界にテイクオフ！",
                "プリキュア！マジェスティックハレーション！"),
                messageTester.messages);
    }
}
