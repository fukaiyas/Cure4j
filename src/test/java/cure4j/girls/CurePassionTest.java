package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CurePassionTest extends GirlTestBase {

    CurePassion passion = Cure.passion;

    @Test
    void 基本情報(){
        assertEquals("cure_passion", passion.girlName());
        assertEquals("東せつな", passion.humanName());
        assertEquals("東せつな", passion.fullName());
        assertEquals("Undefined.", passion.humanFullName());
        assertEquals("キュアパッション", passion.precureName());
        assertEquals("小松由佳", passion.castName());
        assertEquals(LocalDate.of(2009, 7, 12), passion.createdDate());
        assertEquals(PrecureColor.RED, passion.color());
        assertFalse(passion.hasBirthday());
        assertEquals("チェインジ！プリキュア・ビートアップ！\n" +
                        "真っ赤なハートは幸せの証！\n" +
                        "熟れたてフレッシュ、キュアパッション！\n" +
                        "レッツプリキュア！",
                        passion.getTransformMessage());
        assertEquals(List.of("キュアエンジェルパッション"), passion.getExtraNames());
        assertEquals(1, passion.getAttackMessages().size());
        assertEquals("吹き荒れよ幸せの嵐！\n" +
                        "プリキュア！ハピネスハリケーン！",
                passion.getAttackMessages().get(0));
        assertEquals(List.of("change_precure_beat_up",
                "change",
                "beat_up"),
                passion.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(passion, Girl.byName("passion"));
    }

    @Test
    void 変身() {
        passion.humanize();

        assertEquals("東せつな", passion.name());
        passion.transform();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "真っ赤なハートは幸せの証！",
                        "熟れたてフレッシュ、キュアパッション！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパッション", passion.name());

        messageTester.messages.clear();
        passion.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアエンジェルパッション", passion.name());

        messageTester.messages.clear();
        passion.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("東せつな", passion.name());

        messageTester.messages.clear();
        passion.changePrecureBeatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "真っ赤なハートは幸せの証！",
                        "熟れたてフレッシュ、キュアパッション！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパッション", passion.name());

        messageTester.messages.clear();
        passion.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("東せつな", passion.name());

        messageTester.messages.clear();
        passion.change();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "真っ赤なハートは幸せの証！",
                        "熟れたてフレッシュ、キュアパッション！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパッション", passion.name());

        messageTester.messages.clear();
        passion.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("東せつな", passion.name());

        messageTester.messages.clear();
        passion.beatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "真っ赤なハートは幸せの証！",
                        "熟れたてフレッシュ、キュアパッション！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパッション", passion.name());

        messageTester.messages.clear();
        passion.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("東せつな", passion.name());
    }

    @Test
    void 攻撃(){
        passion.humanize();
        assertThrows(RequireTransformException.class, () -> passion.attack(), "Require transform.");

        passion.transform();
        assertEquals("キュアパッション", passion.name());
        messageTester.messages.clear();
        passion.attack();
        assertEquals(List.of("吹き荒れよ幸せの嵐！",
                        "プリキュア！ハピネスハリケーン！"),
                messageTester.messages);

        passion.transform();
        assertEquals("キュアエンジェルパッション", passion.name());
        messageTester.messages.clear();
        passion.attack();
        assertEquals(List.of("吹き荒れよ幸せの嵐！",
                        "プリキュア！ハピネスハリケーン！"),
                messageTester.messages);
    }
}
