package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CurePineTest extends GirlTestBase {

    CurePine pine = Cure.pine;

    @Test
    void 基本情報(){
        assertEquals("cure_pine", pine.girlName());
        assertEquals("山吹祈里", pine.humanName());
        assertEquals("山吹祈里", pine.fullName());
        assertEquals("Undefined.", pine.humanFullName());
        assertEquals("キュアパイン", pine.precureName());
        assertEquals("中川亜紀子", pine.castName());
        assertEquals(LocalDate.of(2009, 2, 15), pine.createdDate());
        assertEquals(PrecureColor.YELLOW, pine.color());
        assertFalse(pine.hasBirthday());
        assertEquals("チェインジ！プリキュア・ビートアップ！\n" +
                        "イエローハートは祈りのしるし！\n" +
                        "とれたてフレッシュ、キュアパイン！\n" +
                        "レッツプリキュア！",
                        pine.getTransformMessage());
        assertEquals(List.of("キュアエンジェルパイン"), pine.getExtraNames());
        assertEquals(1, pine.getAttackMessages().size());
        assertEquals("悪いの悪いの飛んでいけ！\n" +
                        "プリキュア！ヒーリングプレアーフレッシュ！",
                pine.getAttackMessages().get(0));
        assertEquals(List.of("change_precure_beat_up",
                "change",
                "beat_up"),
                pine.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(pine, Girl.byName("pine"));
    }

    @Test
    void 変身() {
        pine.humanize();

        assertEquals("山吹祈里", pine.name());
        pine.transform();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "イエローハートは祈りのしるし！",
                        "とれたてフレッシュ、キュアパイン！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパイン", pine.name());

        messageTester.messages.clear();
        pine.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアエンジェルパイン", pine.name());

        messageTester.messages.clear();
        pine.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("山吹祈里", pine.name());

        messageTester.messages.clear();
        pine.changePrecureBeatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "イエローハートは祈りのしるし！",
                        "とれたてフレッシュ、キュアパイン！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパイン", pine.name());

        messageTester.messages.clear();
        pine.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("山吹祈里", pine.name());

        messageTester.messages.clear();
        pine.change();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "イエローハートは祈りのしるし！",
                        "とれたてフレッシュ、キュアパイン！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパイン", pine.name());

        messageTester.messages.clear();
        pine.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("山吹祈里", pine.name());

        messageTester.messages.clear();
        pine.beatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "イエローハートは祈りのしるし！",
                        "とれたてフレッシュ、キュアパイン！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアパイン", pine.name());

        messageTester.messages.clear();
        pine.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("山吹祈里", pine.name());
    }

    @Test
    void 攻撃(){
        pine.humanize();
        assertThrows(RequireTransformException.class, () -> pine.attack(), "Require transform.");

        pine.transform();
        messageTester.messages.clear();
        pine.attack();
        assertEquals(List.of("悪いの悪いの飛んでいけ！",
                        "プリキュア！ヒーリングプレアーフレッシュ！"),
                messageTester.messages);
    }
}
