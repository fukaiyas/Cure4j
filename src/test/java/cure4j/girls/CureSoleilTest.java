package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureSoleilTest extends GirlTestBase {

    CureSoleil soleil = Cure.soleil;

    @Test
    void 基本情報(){
        assertEquals("cure_soleil", soleil.girlName());
        assertEquals("天宮えれな", soleil.humanName());
        assertEquals("天宮えれな", soleil.fullName());
        assertEquals("Undefined.", soleil.humanFullName());
        assertEquals("キュアソレイユ", soleil.precureName());
        assertEquals("安野希世乃", soleil.castName());
        assertEquals(LocalDate.of(2019, 2, 24), soleil.createdDate());
        assertEquals(PrecureColor.YELLOW, soleil.color());
        assertEquals("9/8", soleil.birthday());
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
                "宇宙を照らす！灼熱のきらめき！キュアソレイユ！",
                soleil.getTransformMessage());
        assertEquals(0, soleil.getExtraNames().size());
        assertEquals(1, soleil.getAttackMessages().size());
        assertEquals("プリキュア！ソレイユシュート！",
                soleil.getAttackMessages().get(0));
        assertEquals(List.of("color_charge"), soleil.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(soleil, Girl.byName("soleil"));
    }

    @Test
    void 変身() {
        soleil.humanize();

        assertEquals("天宮えれな", soleil.name());
        soleil.transform();
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
                "宇宙を照らす！灼熱のきらめき！キュアソレイユ！"),
                messageTester.messages);
        assertEquals("キュアソレイユ", soleil.name());

        messageTester.messages.clear();
        soleil.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("天宮えれな", soleil.name());

        messageTester.messages.clear();
        soleil.colorCharge();
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
                "宇宙を照らす！灼熱のきらめき！キュアソレイユ！"),
                messageTester.messages);
        assertEquals("キュアソレイユ", soleil.name());

        messageTester.messages.clear();
        soleil.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("天宮えれな", soleil.name());
    }

    @Test
    void 攻撃(){
        soleil.humanize();
        assertThrows(RequireTransformException.class, () -> soleil.attack(), "Require transform.");

        soleil.transform();
        messageTester.messages.clear();
        soleil.attack();
        assertEquals(List.of("プリキュア！ソレイユシュート！"),
                messageTester.messages);
    }
}
