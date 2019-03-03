package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureSeleneTest extends GirlTestBase {

    CureSelene selene = Cure.selene;

    @Test
    void 基本情報(){
        assertEquals("cure_selene", selene.girlName());
        assertEquals("香久矢まどか", selene.humanName());
        assertEquals("香久矢まどか", selene.fullName());
        assertEquals("Undefined.", selene.humanFullName());
        assertEquals("キュアセレーネ", selene.precureName());
        assertEquals("小松未可子", selene.castName());
        assertEquals(LocalDate.of(2019, 3, 3), selene.createdDate());
        assertEquals(PrecureColor.PURPLE, selene.color());
        assertEquals("11/23", selene.birthday());
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
                "夜空に輝く！神秘の月あかり！キュアセレーネ！",
                selene.getTransformMessage());
        assertEquals(0, selene.getExtraNames().size());
        assertEquals(1, selene.getAttackMessages().size());
        assertEquals("プリキュア！セレーネアロー！",
                selene.getAttackMessages().get(0));
        assertEquals(List.of("color_charge"), selene.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(selene, Girl.byName("selene"));
    }

    @Test
    void 変身() {
        selene.humanize();

        assertEquals("香久矢まどか", selene.name());
        selene.transform();
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
                "夜空に輝く！神秘の月あかり！キュアセレーネ！"),
                messageTester.messages);
        assertEquals("キュアセレーネ", selene.name());

        messageTester.messages.clear();
        selene.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("香久矢まどか", selene.name());

        messageTester.messages.clear();
        selene.colorCharge();
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
                "夜空に輝く！神秘の月あかり！キュアセレーネ！"),
                messageTester.messages);
        assertEquals("キュアセレーネ", selene.name());

        messageTester.messages.clear();
        selene.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("香久矢まどか", selene.name());
    }

    @Test
    void 攻撃(){
        selene.humanize();
        assertThrows(RequireTransformException.class, () -> selene.attack(), "Require transform.");

        selene.transform();
        messageTester.messages.clear();
        selene.attack();
        assertEquals(List.of("プリキュア！セレーネアロー！"),
                messageTester.messages);
    }
}
