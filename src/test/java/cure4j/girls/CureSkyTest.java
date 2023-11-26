package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureSkyTest extends GirlTestBase {

    CureSky sky = Cure.sky;

    @Test
    void 基本情報(){
        assertEquals("cure_sky", sky.girlName());
        assertEquals("ソラ・ハレワタール", sky.humanName());
        assertEquals("ソラ・ハレワタール", sky.fullName());
        assertEquals("Undefined.", sky.humanFullName());
        assertEquals("キュアスカイ", sky.precureName());
        assertEquals("関根明良", sky.castName());
        assertEquals(LocalDate.of(2023, 2, 5), sky.createdDate());
        assertEquals(PrecureColor.BLUE, sky.color());
        assertEquals("9/20", sky.birthday());
        assertEquals("""
                ヒーローの出番です！
                スカイミラージュ！
                トーンコネクト！
                ひろがるチェンジ！
                スカイ！
                きらめきHOP
                さわやかSTEP
                はればれJUMP
                無限にひろがる青い空！キュアスカイ！
                Ready…Go!
                ひろがるスカイ！プリキュア！""",
                sky.getTransformMessage());
        assertEquals(0, sky.getExtraNames().size());
        assertEquals(1, sky.getAttackMessages().size());
        assertEquals("ヒーローガールスカイパンチ！",
                sky.getAttackMessages().get(0));
        assertEquals(List.of("sky_mirage_tone_connect"), sky.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(sky, Girl.byName("sky"));
    }

    @Test
    void 変身() {
        sky.humanize();

        assertEquals("ソラ・ハレワタール", sky.name());
        sky.transform();
        assertEquals(List.of("ヒーローの出番です！",
                "スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "スカイ！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "無限にひろがる青い空！キュアスカイ！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアスカイ", sky.name());

        messageTester.messages.clear();
        sky.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ソラ・ハレワタール", sky.name());

        messageTester.messages.clear();
        sky.skyMirageToneConnect();
        assertEquals(List.of("ヒーローの出番です！",
                "スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "スカイ！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "無限にひろがる青い空！キュアスカイ！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアスカイ", sky.name());

        messageTester.messages.clear();
        sky.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ソラ・ハレワタール", sky.name());
    }

    @Test
    void 攻撃(){
        sky.humanize();
        assertThrows(RequireTransformException.class, () -> sky.attack(), "Require transform.");

        sky.transform();
        messageTester.messages.clear();
        sky.attack();
        assertEquals(List.of("ヒーローガールスカイパンチ！"),
                messageTester.messages);
    }
}
