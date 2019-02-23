package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureMacherieTest extends GirlTestBase {

    CureMacherie macherie = Cure.macherie;

    @Test
    void 基本情報(){
        assertEquals("cure_macherie", macherie.girlName());
        assertEquals("愛崎えみる", macherie.humanName());
        assertEquals("愛崎えみる", macherie.fullName());
        assertEquals("Undefined.", macherie.humanFullName());
        assertEquals("キュアマシェリ", macherie.precureName());
        assertEquals("田村奈央", macherie.castName());
        assertEquals(LocalDate.of(2018, 6, 17), macherie.createdDate());
        assertEquals(PrecureColor.RED, macherie.color());
        assertEquals("7/15", macherie.birthday());
        assertEquals("ミライクリスタル！\n" +
                "ハートキラっと！\n" +
                "は～ぎゅ～～！\n" +
                "ぎゅ～！\n" +
                "ぎゅ～～！\n" +
                "輝く未来を抱きしめて！\n" +
                "みんな大好き！愛のプリキュア！キュアマシェリ！",
                macherie.getTransformMessage());
        assertEquals(0, macherie.getExtraNames().size());
        assertEquals(1, macherie.getAttackMessages().size());
        assertEquals("Are you ready?\n" +
                "フレフレ！ハート・ソング！",
                macherie.getAttackMessages().get(0));
        assertEquals(List.of("heart_kiratto"), macherie.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(macherie, Girl.byName("macherie"));
    }

    @Test
    void 変身() {
        macherie.humanize();

        assertEquals("愛崎えみる", macherie.name());
        macherie.transform();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんな大好き！愛のプリキュア！キュアマシェリ！"),
                messageTester.messages);
        assertEquals("キュアマシェリ", macherie.name());

        messageTester.messages.clear();
        macherie.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("愛崎えみる", macherie.name());

        messageTester.messages.clear();
        macherie.heartKiratto();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんな大好き！愛のプリキュア！キュアマシェリ！"),
                messageTester.messages);
        assertEquals("キュアマシェリ", macherie.name());

        messageTester.messages.clear();
        macherie.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("愛崎えみる", macherie.name());
    }

    @Test
    void 攻撃(){
        macherie.humanize();
        assertThrows(RequireTransformException.class, () -> macherie.attack(), "Require transform.");

        macherie.transform();
        messageTester.messages.clear();
        macherie.attack();
        assertEquals(List.of("Are you ready?",
                "フレフレ！ハート・ソング！"),
                messageTester.messages);
    }
}
