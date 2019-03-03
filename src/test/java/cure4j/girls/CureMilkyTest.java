package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureMilkyTest extends GirlTestBase {

    CureMilky milky = Cure.milky;

    @Test
    void 基本情報(){
        assertEquals("cure_milky", milky.girlName());
        assertEquals("羽衣ララ", milky.humanName());
        assertEquals("羽衣ララ", milky.fullName());
        assertEquals("Undefined.", milky.humanFullName());
        assertEquals("キュアミルキー", milky.precureName());
        assertEquals("小原好美", milky.castName());
        assertEquals(LocalDate.of(2019, 2, 10), milky.createdDate());
        assertEquals(PrecureColor.GREEN, milky.color());
        assertEquals("7/7", milky.birthday());
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
                "天にあまねくミルキーウェイ！キュアミルキー！",
                milky.getTransformMessage());
        assertEquals(0, milky.getExtraNames().size());
        assertEquals(1, milky.getAttackMessages().size());
        assertEquals("プリキュア！ミルキーショック！",
                milky.getAttackMessages().get(0));
        assertEquals(List.of("color_charge"), milky.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(milky, Girl.byName("milky"));
    }

    @Test
    void 変身() {
        milky.humanize();

        assertEquals("羽衣ララ", milky.name());
        milky.transform();
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
                "天にあまねくミルキーウェイ！キュアミルキー！"),
                messageTester.messages);
        assertEquals("キュアミルキー", milky.name());

        messageTester.messages.clear();
        milky.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("羽衣ララ", milky.name());

        messageTester.messages.clear();
        milky.colorCharge();
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
                "天にあまねくミルキーウェイ！キュアミルキー！"),
                messageTester.messages);
        assertEquals("キュアミルキー", milky.name());

        messageTester.messages.clear();
        milky.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("羽衣ララ", milky.name());
    }

    @Test
    void 攻撃(){
        milky.humanize();
        assertThrows(RequireTransformException.class, () -> milky.attack(), "Require transform.");

        milky.transform();
        messageTester.messages.clear();
        milky.attack();
        assertEquals(List.of("プリキュア！ミルキーショック！"),
                messageTester.messages);
    }
}
