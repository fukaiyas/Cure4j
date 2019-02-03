package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CurePeachTest extends GirlTestBase {

    CurePeach peach = Cure.peach;

    @Test
    void 基本情報(){
        assertEquals("cure_peach", peach.girlName());
        assertEquals("桃園ラブ", peach.humanName());
        assertEquals("桃園ラブ", peach.fullName());
        assertEquals("Undefined.", peach.humanFullName());
        assertEquals("キュアピーチ", peach.precureName());
        assertEquals("沖佳苗", peach.castName());
        assertEquals(LocalDate.of(2009, 2, 1), peach.createdDate());
        assertEquals(PrecureColor.PINK, peach.color());
        assertFalse(peach.hasBirthday());
        assertEquals("チェインジ！プリキュア・ビートアップ！\n" +
                        "ピンクのハートは愛あるしるし！\n" +
                        "もぎたてフレッシュ、キュアピーチ！\n" +
                        "レッツプリキュア！",
                        peach.getTransformMessage());
        assertEquals(List.of("キュアエンジェルピーチ"), peach.getExtraNames());
        assertEquals(1, peach.getAttackMessages().size());
        assertEquals("悪いの悪いの飛んでいけ！\n" +
                        "プリキュア！ラブサンシャインフレッシュ！",
                peach.getAttackMessages().get(0));
        assertEquals(List.of("change_precure_beat_up",
                "change",
                "beat_up"),
                peach.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(peach, Girl.byName("peach"));
    }

    @Test
    void 変身() {
        peach.humanize();

        assertEquals("桃園ラブ", peach.name());
        peach.transform();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ピンクのハートは愛あるしるし！",
                        "もぎたてフレッシュ、キュアピーチ！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアピーチ", peach.name());

        messageTester.messages.clear();
        peach.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアエンジェルピーチ", peach.name());

        messageTester.messages.clear();
        peach.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("桃園ラブ", peach.name());

        messageTester.messages.clear();
        peach.changePrecureBeatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ピンクのハートは愛あるしるし！",
                        "もぎたてフレッシュ、キュアピーチ！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアピーチ", peach.name());

        messageTester.messages.clear();
        peach.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("桃園ラブ", peach.name());

        messageTester.messages.clear();
        peach.change();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ピンクのハートは愛あるしるし！",
                        "もぎたてフレッシュ、キュアピーチ！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアピーチ", peach.name());

        messageTester.messages.clear();
        peach.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("桃園ラブ", peach.name());

        messageTester.messages.clear();
        peach.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("桃園ラブ", peach.name());

        messageTester.messages.clear();
        peach.beatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ピンクのハートは愛あるしるし！",
                        "もぎたてフレッシュ、キュアピーチ！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアピーチ", peach.name());

        messageTester.messages.clear();
        peach.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("桃園ラブ", peach.name());
    }

    @Test
    void 攻撃(){
        peach.humanize();
        assertThrows(RequireTransformException.class, () -> peach.attack(), "Require transform.");

        peach.transform();
        messageTester.messages.clear();
        peach.attack();
        assertEquals(List.of("悪いの悪いの飛んでいけ！",
                        "プリキュア！ラブサンシャインフレッシュ！"),
                messageTester.messages);
    }
}
