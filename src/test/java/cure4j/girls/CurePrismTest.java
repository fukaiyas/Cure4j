package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurePrismTest extends GirlTestBase {

    CurePrism prism = Cure.prism;

    @Test
    void 基本情報(){
        assertEquals("cure_prism", prism.girlName());
        assertEquals("虹ヶ丘ましろ", prism.humanName());
        assertEquals("虹ヶ丘ましろ", prism.fullName());
        assertEquals("Undefined.", prism.humanFullName());
        assertEquals("キュアプリズム", prism.precureName());
        assertEquals("加隈亜衣", prism.castName());
        assertEquals(LocalDate.of(2023, 2, 26), prism.createdDate());
        assertEquals(PrecureColor.WHITE, prism.color());
        assertEquals("7/16", prism.birthday());
        assertEquals("""
                ヒーローの出番だよ！
                スカイミラージュ！
                トーンコネクト！
                ひろがるチェンジ！
                プリズム！
                きらめきHOP
                さわやかSTEP
                はればれJUMP
                ふわりひろがる優しい光！キュアプリズム！
                Ready…Go!
                ひろがるスカイ！プリキュア！""",
                prism.getTransformMessage());
        assertEquals(0, prism.getExtraNames().size());
        assertEquals(1, prism.getAttackMessages().size());
        assertEquals("ヒーローガールプリズムショット！",
                prism.getAttackMessages().get(0));
        assertEquals(List.of("sky_mirage_tone_connect"), prism.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(prism, Girl.byName("prism"));
    }

    @Test
    void 変身() {
        prism.humanize();

        assertEquals("虹ヶ丘ましろ", prism.name());
        prism.transform();
        assertEquals(List.of("ヒーローの出番だよ！",
                "スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "プリズム！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "ふわりひろがる優しい光！キュアプリズム！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアプリズム", prism.name());

        messageTester.messages.clear();
        prism.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("虹ヶ丘ましろ", prism.name());

        messageTester.messages.clear();
        prism.skyMirageToneConnect();
        assertEquals(List.of("ヒーローの出番だよ！",
                "スカイミラージュ！",
                "トーンコネクト！",
                "ひろがるチェンジ！",
                "プリズム！",
                "きらめきHOP",
                "さわやかSTEP",
                "はればれJUMP",
                "ふわりひろがる優しい光！キュアプリズム！",
                "Ready…Go!",
                "ひろがるスカイ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアプリズム", prism.name());

        messageTester.messages.clear();
        prism.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("虹ヶ丘ましろ", prism.name());
    }

    @Test
    void 攻撃(){
        prism.humanize();
        assertThrows(RequireTransformException.class, () -> prism.attack(), "Require transform.");

        prism.transform();
        messageTester.messages.clear();
        prism.attack();
        assertEquals(List.of("ヒーローガールプリズムショット！"),
                messageTester.messages);
    }
}
