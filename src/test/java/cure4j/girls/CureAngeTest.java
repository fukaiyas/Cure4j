package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureAngeTest extends GirlTestBase {

    CureAnge ange = Cure.ange;

    @Test
    void 基本情報(){
        assertEquals("cure_ange", ange.girlName());
        assertEquals("薬師寺さあや", ange.humanName());
        assertEquals("薬師寺さあや", ange.fullName());
        assertEquals("Undefined.", ange.humanFullName());
        assertEquals("キュアアンジュ", ange.precureName());
        assertEquals("本泉莉奈", ange.castName());
        assertEquals(LocalDate.of(2018, 2, 11), ange.createdDate());
        assertEquals(PrecureColor.BLUE, ange.color());
        assertEquals("6/10", ange.birthday());
        assertEquals("ミライクリスタル！\n" +
                "ハートキラっと！\n" +
                "は～ぎゅ～～！\n" +
                "ぎゅ～！\n" +
                "ぎゅ～～！\n" +
                "輝く未来を抱きしめて！\n" +
                "みんなを癒す！知恵のプリキュア！キュアアンジュ！",
                ange.getTransformMessage());
        assertEquals(0, ange.getExtraNames().size());
        assertEquals(1, ange.getAttackMessages().size());
        assertEquals("フレフレ！ハート・フェザー！",
                ange.getAttackMessages().get(0));
        assertEquals(List.of("heart_kiratto"), ange.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(ange, Girl.byName("ange"));
    }

    @Test
    void 変身() {
        ange.humanize();

        assertEquals("薬師寺さあや", ange.name());
        ange.transform();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんなを癒す！知恵のプリキュア！キュアアンジュ！"),
                messageTester.messages);
        assertEquals("キュアアンジュ", ange.name());

        messageTester.messages.clear();
        ange.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("薬師寺さあや", ange.name());

        messageTester.messages.clear();
        ange.heartKiratto();
        assertEquals(List.of("ミライクリスタル！",
                "ハートキラっと！",
                "は～ぎゅ～～！",
                "ぎゅ～！",
                "ぎゅ～～！",
                "輝く未来を抱きしめて！",
                "みんなを癒す！知恵のプリキュア！キュアアンジュ！"),
                messageTester.messages);
        assertEquals("キュアアンジュ", ange.name());

        messageTester.messages.clear();
        ange.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("薬師寺さあや", ange.name());
    }

    @Test
    void 攻撃(){
        ange.humanize();
        assertThrows(RequireTransformException.class, () -> ange.attack(), "Require transform.");

        ange.transform();
        messageTester.messages.clear();
        ange.attack();
        assertEquals(List.of("フレフレ！ハート・フェザー！"),
                messageTester.messages);
    }
}
