package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureCustardTest extends GirlTestBase {

    CureCustard custard = Cure.custard;

    @Test
    void 基本情報(){
        assertEquals("cure_custard", custard.girlName());
        assertEquals("有栖川ひまり", custard.humanName());
        assertEquals("有栖川ひまり", custard.fullName());
        assertEquals("Undefined.", custard.humanFullName());
        assertEquals("キュアカスタード", custard.precureName());
        assertEquals("福原遥", custard.castName());
        assertEquals(LocalDate.of(2017, 2, 12), custard.createdDate());
        assertEquals(PrecureColor.YELLOW, custard.color());
        assertEquals("4/16", custard.birthday());
        assertEquals("キュアラモード・デコレーション！\n" +
                "プリン！\n" +
                "知性と勇気を！\n" +
                "レッツ・ラ・まぜまぜ！\n" +
                "キュアカスタード！できあがり！\n" +
                "キラキラ☆プリキュアアラモード！",
                custard.getTransformMessage());
        assertEquals(0, custard.getExtraNames().size());
        assertEquals(1, custard.getAttackMessages().size());
        assertEquals("キラキラキラルン！カスタード・イリュージョン！",
                custard.getAttackMessages().get(0));
        assertEquals(List.of("cure_la_mode_decoration"), custard.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(custard, Girl.byName("custard"));
    }

    @Test
    void 変身() {
        custard.humanize();

        assertEquals("有栖川ひまり", custard.name());
        custard.transform();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "プリン！",
                "知性と勇気を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアカスタード！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアカスタード", custard.name());

        messageTester.messages.clear();
        custard.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("有栖川ひまり", custard.name());

        messageTester.messages.clear();
        custard.cureLaModeDecoration();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "プリン！",
                "知性と勇気を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアカスタード！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアカスタード", custard.name());

        messageTester.messages.clear();
        custard.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("有栖川ひまり", custard.name());
    }

    @Test
    void 攻撃(){
        custard.humanize();
        assertThrows(RequireTransformException.class, () -> custard.attack(), "Require transform.");

        custard.transform();
        messageTester.messages.clear();
        custard.attack();
        assertEquals(List.of("キラキラキラルン！カスタード・イリュージョン！"),
                messageTester.messages);
    }
}
