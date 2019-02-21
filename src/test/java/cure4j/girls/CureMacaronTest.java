package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureMacaronTest extends GirlTestBase {

    CureMacaron macaron = Cure.macaron;

    @Test
    void 基本情報(){
        assertEquals("cure_macaron", macaron.girlName());
        assertEquals("琴爪ゆかり", macaron.humanName());
        assertEquals("琴爪ゆかり", macaron.fullName());
        assertEquals("Undefined.", macaron.humanFullName());
        assertEquals("キュアマカロン", macaron.precureName());
        assertEquals("藤田咲", macaron.castName());
        assertEquals(LocalDate.of(2017, 3, 5), macaron.createdDate());
        assertEquals(PrecureColor.PURPLE, macaron.color());
        assertEquals("6/11", macaron.birthday());
        assertEquals("キュアラモード・デコレーション！\n" +
                "マカロン！\n" +
                "美しさとときめきを！\n" +
                "レッツ・ラ・まぜまぜ！\n" +
                "キュアマカロン！できあがり！\n" +
                "キラキラ☆プリキュアアラモード！",
                macaron.getTransformMessage());
        assertEquals(0, macaron.getExtraNames().size());
        assertEquals(1, macaron.getAttackMessages().size());
        assertEquals("キラキラキラルン！マカロン・ジュリエンヌ！にゃ～お☆",
                macaron.getAttackMessages().get(0));
        assertEquals(List.of("cure_la_mode_decoration"), macaron.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(macaron, Girl.byName("macaron"));
    }

    @Test
    void 変身() {
        macaron.humanize();

        assertEquals("琴爪ゆかり", macaron.name());
        macaron.transform();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "マカロン！",
                "美しさとときめきを！",
                "レッツ・ラ・まぜまぜ！",
                "キュアマカロン！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアマカロン", macaron.name());

        messageTester.messages.clear();
        macaron.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("琴爪ゆかり", macaron.name());

        messageTester.messages.clear();
        macaron.cureLaModeDecoration();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "マカロン！",
                "美しさとときめきを！",
                "レッツ・ラ・まぜまぜ！",
                "キュアマカロン！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアマカロン", macaron.name());

        messageTester.messages.clear();
        macaron.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("琴爪ゆかり", macaron.name());
    }

    @Test
    void 攻撃(){
        macaron.humanize();
        assertThrows(RequireTransformException.class, () -> macaron.attack(), "Require transform.");

        macaron.transform();
        messageTester.messages.clear();
        macaron.attack();
        assertEquals(List.of("キラキラキラルン！マカロン・ジュリエンヌ！にゃ～お☆"),
                messageTester.messages);
    }
}
