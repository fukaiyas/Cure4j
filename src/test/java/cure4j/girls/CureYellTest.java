package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureYellTest extends GirlTestBase {

    CureYell yell = Cure.yell;

    @Test
    void 基本情報(){
        assertEquals("cure_yell", yell.girlName());
        assertEquals("野乃はな", yell.humanName());
        assertEquals("野乃はな", yell.fullName());
        assertEquals("Undefined.", yell.humanFullName());
        assertEquals("キュアエール", yell.precureName());
        assertEquals("引坂理絵", yell.castName());
        assertEquals(LocalDate.of(2018, 2, 4), yell.createdDate());
        assertEquals(PrecureColor.PINK, yell.color());
        assertEquals("1/20", yell.birthday());
        assertEquals("ミライクリスタル！\n" +
                "ハートキラっと！\n" +
                "は～ぎゅ～～！\n" +
                "ぎゅ～！\n" +
                "ぎゅ～～！\n" +
                "輝く未来を抱きしめて！\n" +
                "みんなを応援！元気のプリキュア！キュアエール！",
                yell.getTransformMessage());
        assertEquals(0, yell.getExtraNames().size());
        assertEquals(1, yell.getAttackMessages().size());
        assertEquals("フレフレ！ハート・フォー・ユー！",
                yell.getAttackMessages().get(0));
        assertEquals(List.of("heart_kiratto"), yell.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(yell, Girl.byName("yell"));
    }

    @Test
    void 変身() {
        yell.humanize();

        assertEquals("野乃はな", yell.name());
        yell.transform();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんなを応援！元気のプリキュア！キュアエール！"),
                messageTester.messages);
        assertEquals("キュアエール", yell.name());

        messageTester.messages.clear();
        yell.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("野乃はな", yell.name());

        messageTester.messages.clear();
        yell.heartKiratto();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんなを応援！元気のプリキュア！キュアエール！"),
                messageTester.messages);
        assertEquals("キュアエール", yell.name());

        messageTester.messages.clear();
        yell.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("野乃はな", yell.name());
    }

    @Test
    void 攻撃(){
        yell.humanize();
        assertThrows(RequireTransformException.class, () -> yell.attack(), "Require transform.");

        yell.transform();
        messageTester.messages.clear();
        yell.attack();
        assertEquals(List.of("フレフレ！ハート・フォー・ユー！"),
                messageTester.messages);
    }
}
