package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureAmourTest extends GirlTestBase {

    CureAmour amour = Cure.amour;

    @Test
    void 基本情報(){
        assertEquals("cure_amour", amour.girlName());
        assertEquals("ルールー・アムール", amour.humanName());
        assertEquals("ルールー・アムール", amour.fullName());
        assertEquals("Undefined.", amour.humanFullName());
        assertEquals("キュアアムール", amour.precureName());
        assertEquals("田村ゆかり", amour.castName());
        assertEquals(LocalDate.of(2018, 6, 17), amour.createdDate());
        assertEquals(PrecureColor.PURPLE, amour.color());
        assertEquals("9/23", amour.birthday());
        assertEquals("ミライクリスタル！\n" +
                "ハートキラっと！\n" +
                "は～ぎゅ～～！\n" +
                "ぎゅ～！\n" +
                "ぎゅ～～！\n" +
                "輝く未来を抱きしめて！\n" +
                "みんな大好き！愛のプリキュア！キュアアムール！",
                amour.getTransformMessage());
        assertEquals(0, amour.getExtraNames().size());
        assertEquals(1, amour.getAttackMessages().size());
        assertEquals("いきます！\n" +
                "フレフレ！ハート・ダンス！",
                amour.getAttackMessages().get(0));
        assertEquals(List.of("heart_kiratto"), amour.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(amour, Girl.byName("amour"));
    }

    @Test
    void 変身() {
        amour.humanize();

        assertEquals("ルールー・アムール", amour.name());
        amour.transform();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんな大好き！愛のプリキュア！キュアアムール！"),
                messageTester.messages);
        assertEquals("キュアアムール", amour.name());

        messageTester.messages.clear();
        amour.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ルールー・アムール", amour.name());

        messageTester.messages.clear();
        amour.heartKiratto();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんな大好き！愛のプリキュア！キュアアムール！"),
                messageTester.messages);
        assertEquals("キュアアムール", amour.name());

        messageTester.messages.clear();
        amour.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ルールー・アムール", amour.name());
    }

    @Test
    void 攻撃(){
        amour.humanize();
        assertThrows(RequireTransformException.class, () -> amour.attack(), "Require transform.");

        amour.transform();
        messageTester.messages.clear();
        amour.attack();
        assertEquals(List.of("いきます！",
                "フレフレ！ハート・ダンス！"),
                messageTester.messages);
    }
}
