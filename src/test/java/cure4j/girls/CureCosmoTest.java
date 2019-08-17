package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureCosmoTest extends GirlTestBase {

    CureCosmo cosmo = Cure.cosmo;

    @Test
    void 基本情報(){
        assertEquals("cure_cosmo", cosmo.girlName());
        assertEquals("ユニ", cosmo.humanName());
        assertEquals("ユニ", cosmo.fullName());
        assertEquals("Undefined.", cosmo.humanFullName());
        assertEquals("キュアコスモ", cosmo.precureName());
        assertEquals("上坂すみれ", cosmo.castName());
        assertEquals(LocalDate.of(2019, 6, 23), cosmo.createdDate());
        assertEquals(PrecureColor.RAINBOW, cosmo.color());
        assertEquals("10/11", cosmo.birthday());
        assertEquals("スターカラーペンダント！\n" +
                "カラーチャージ！\n" +
                "煌めくー\n" +
                "星の力でー\n" +
                "憧れのー\n" +
                "私えがくよー\n" +
                "トゥインクル！トゥインクル！プリキュア！\n" +
                "トゥインクル！トゥインクル！プリキュア！\n" +
                "トゥインクル！トゥインクル！プリキュア！\n" +
                "スター☆トゥインクル！\n" +
                "スター☆トゥインクル！プリキュア！\n" +
                "あー！\n" +
                "銀河に光る虹色のスペクトル！キュアコスモ！",
                cosmo.getTransformMessage());
        assertEquals(0, cosmo.getExtraNames().size());
        assertEquals(1, cosmo.getAttackMessages().size());
        assertEquals("プリキュア！コスモシャイニング！",
                cosmo.getAttackMessages().get(0));
        assertEquals(List.of("color_charge"), cosmo.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(cosmo, Girl.byName("cosmo"));
    }

    @Test
    void 変身() {
        cosmo.humanize();

        assertEquals("ユニ", cosmo.name());
        cosmo.transform();
        assertEquals(List.of("スターカラーペンダント！",
                "カラーチャージ！",
                "煌めくー",
                "星の力でー",
                "憧れのー",
                "私えがくよー",
                "トゥインクル！トゥインクル！プリキュア！",
                "トゥインクル！トゥインクル！プリキュア！",
                "トゥインクル！トゥインクル！プリキュア！",
                "スター☆トゥインクル！",
                "スター☆トゥインクル！プリキュア！",
                "あー！",
                "銀河に光る虹色のスペクトル！キュアコスモ！"),
                messageTester.messages);
        assertEquals("キュアコスモ", cosmo.name());

        messageTester.messages.clear();
        cosmo.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ユニ", cosmo.name());

        messageTester.messages.clear();
        cosmo.colorCharge();
        assertEquals(List.of("スターカラーペンダント！",
                "カラーチャージ！",
                "煌めくー",
                "星の力でー",
                "憧れのー",
                "私えがくよー",
                "トゥインクル！トゥインクル！プリキュア！",
                "トゥインクル！トゥインクル！プリキュア！",
                "トゥインクル！トゥインクル！プリキュア！",
                "スター☆トゥインクル！",
                "スター☆トゥインクル！プリキュア！",
                "あー！",
                "銀河に光る虹色のスペクトル！キュアコスモ！"),
                messageTester.messages);
        assertEquals("キュアコスモ", cosmo.name());

        messageTester.messages.clear();
        cosmo.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ユニ", cosmo.name());
    }

    @Test
    void 攻撃(){
        cosmo.humanize();
        assertThrows(RequireTransformException.class, () -> cosmo.attack(), "Require transform.");

        cosmo.transform();
        messageTester.messages.clear();
        cosmo.attack();
        assertEquals(List.of("プリキュア！コスモシャイニング！"),
                messageTester.messages);
    }
}
