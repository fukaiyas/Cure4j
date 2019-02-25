package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureStarTest extends GirlTestBase {

    CureStar star = Cure.star;

    @Test
    void 基本情報(){
        assertEquals("cure_star", star.girlName());
        assertEquals("星奈ひかる", star.humanName());
        assertEquals("星奈ひかる", star.fullName());
        assertEquals("Undefined.", star.humanFullName());
        assertEquals("キュアスター", star.precureName());
        assertEquals("成瀬瑛美", star.castName());
        assertEquals(LocalDate.of(2019, 2, 3), star.createdDate());
        assertEquals(PrecureColor.PINK, star.color());
        assertEquals("4/12", star.birthday());
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
                "宇宙に輝くキラキラ星！キュアスター！",
                star.getTransformMessage());
        assertEquals(0, star.getExtraNames().size());
        assertEquals(1, star.getAttackMessages().size());
        assertEquals("プリキュア！スターパンチ！",
                star.getAttackMessages().get(0));
        assertEquals(List.of("color_charge"), star.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(star, Girl.byName("star"));
    }

    @Test
    void 変身() {
        star.humanize();

        assertEquals("星奈ひかる", star.name());
        star.transform();
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
                "宇宙に輝くキラキラ星！キュアスター！"),
                messageTester.messages);
        assertEquals("キュアスター", star.name());

        messageTester.messages.clear();
        star.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("星奈ひかる", star.name());

        messageTester.messages.clear();
        star.colorCharge();
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
                "宇宙に輝くキラキラ星！キュアスター！"),
                messageTester.messages);
        assertEquals("キュアスター", star.name());

        messageTester.messages.clear();
        star.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("星奈ひかる", star.name());
    }

    @Test
    void 攻撃(){
        star.humanize();
        assertThrows(RequireTransformException.class, () -> star.attack(), "Require transform.");

        star.transform();
        messageTester.messages.clear();
        star.attack();
        assertEquals(List.of("プリキュア！スターパンチ！"),
                messageTester.messages);
    }
}
