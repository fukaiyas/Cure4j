package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureChocolatTest extends GirlTestBase {

    CureChocolat chocolat = Cure.chocolat;

    @Test
    void 基本情報(){
        assertEquals("cure_chocolat", chocolat.girlName());
        assertEquals("剣城あきら", chocolat.humanName());
        assertEquals("剣城あきら", chocolat.fullName());
        assertEquals("Undefined.", chocolat.humanFullName());
        assertEquals("キュアショコラ", chocolat.precureName());
        assertEquals("森なな子", chocolat.castName());
        assertEquals(LocalDate.of(2017, 3, 12), chocolat.createdDate());
        assertEquals(PrecureColor.RED, chocolat.color());
        assertEquals("9/24", chocolat.birthday());
        assertEquals("キュアラモード・デコレーション！\n" +
                "チョコレート！\n" +
                "強さと愛を！\n" +
                "レッツ・ラ・まぜまぜ！\n" +
                "キュアショコラ！できあがり！\n" +
                "キラキラ☆プリキュアアラモード！",
                chocolat.getTransformMessage());
        assertEquals(0, chocolat.getExtraNames().size());
        assertEquals(1, chocolat.getAttackMessages().size());
        assertEquals("キラキラキラルン！ショコラ・アロマーゼ！",
                chocolat.getAttackMessages().get(0));
        assertEquals(List.of("cure_la_mode_decoration"), chocolat.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(chocolat, Girl.byName("chocolat"));
    }

    @Test
    void 変身() {
        chocolat.humanize();

        assertEquals("剣城あきら", chocolat.name());
        chocolat.transform();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "チョコレート！",
                "強さと愛を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアショコラ！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアショコラ", chocolat.name());

        messageTester.messages.clear();
        chocolat.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("剣城あきら", chocolat.name());

        messageTester.messages.clear();
        chocolat.cureLaModeDecoration();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "チョコレート！",
                "強さと愛を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアショコラ！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアショコラ", chocolat.name());

        messageTester.messages.clear();
        chocolat.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("剣城あきら", chocolat.name());
    }

    @Test
    void 攻撃(){
        chocolat.humanize();
        assertThrows(RequireTransformException.class, () -> chocolat.attack(), "Require transform.");

        chocolat.transform();
        messageTester.messages.clear();
        chocolat.attack();
        assertEquals(List.of("キラキラキラルン！ショコラ・アロマーゼ！"),
                messageTester.messages);
    }
}
