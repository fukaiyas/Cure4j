package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureGelatoTest extends GirlTestBase {

    CureGelato gelato = Cure.gelato;

    @Test
    void 基本情報(){
        assertEquals("cure_gelato", gelato.girlName());
        assertEquals("立神あおい", gelato.humanName());
        assertEquals("立神あおい", gelato.fullName());
        assertEquals("Undefined.", gelato.humanFullName());
        assertEquals("キュアジェラート", gelato.precureName());
        assertEquals("村中知", gelato.castName());
        assertEquals(LocalDate.of(2017, 2, 19), gelato.createdDate());
        assertEquals(PrecureColor.BLUE, gelato.color());
        assertEquals("8/27", gelato.birthday());
        assertEquals("キュアラモード・デコレーション！\n" +
                "アイス！\n" +
                "自由と情熱を！\n" +
                "レッツ・ラ・まぜまぜ！\n" +
                "キュアジェラート！できあがり！\n" +
                "キラキラ☆プリキュアアラモード！",
                gelato.getTransformMessage());
        assertEquals(0, gelato.getExtraNames().size());
        assertEquals(1, gelato.getAttackMessages().size());
        assertEquals("キラキラキラルン！ジェラート・シェイク！",
                gelato.getAttackMessages().get(0));
        assertEquals(List.of("cure_la_mode_decoration"), gelato.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(gelato, Girl.byName("gelato"));
    }

    @Test
    void 変身() {
        gelato.humanize();

        assertEquals("立神あおい", gelato.name());
        gelato.transform();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "アイス！",
                "自由と情熱を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアジェラート！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアジェラート", gelato.name());

        messageTester.messages.clear();
        gelato.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("立神あおい", gelato.name());

        messageTester.messages.clear();
        gelato.cureLaModeDecoration();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "アイス！",
                "自由と情熱を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアジェラート！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアジェラート", gelato.name());

        messageTester.messages.clear();
        gelato.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("立神あおい", gelato.name());
    }

    @Test
    void 攻撃(){
        gelato.humanize();
        assertThrows(RequireTransformException.class, () -> gelato.attack(), "Require transform.");

        gelato.transform();
        messageTester.messages.clear();
        gelato.attack();
        assertEquals(List.of("キラキラキラルン！ジェラート・シェイク！"),
                messageTester.messages);
    }
}
