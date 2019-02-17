package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureTwinkleTest extends GirlTestBase {

    CureTwinkle twinkle = Cure.twinkle;

    @Test
    void 基本情報(){
        assertEquals("cure_twinkle", twinkle.girlName());
        assertEquals("天ノ川きらら", twinkle.humanName());
        assertEquals("天ノ川きらら", twinkle.fullName());
        assertEquals("Undefined.", twinkle.humanFullName());
        assertEquals("キュアトゥインクル", twinkle.precureName());
        assertEquals("山村響", twinkle.castName());
        assertEquals(LocalDate.of(2015, 2, 22), twinkle.createdDate());
        assertEquals(PrecureColor.YELLOW, twinkle.color());
        assertEquals("9/12", twinkle.birthday());
        assertEquals("プリキュア！プリンセスエンゲージ！\n" +
                "きらめく星のプリンセス！キュアトゥインクル！\n" +
                "強く、やさしく、美しく！\n" +
                "Go!プリンセスプリキュア！\n" +
                "冷たい檻に閉ざされた夢、返していただきますわ！\n" +
                "お覚悟はよろしくて？",
                twinkle.getTransformMessage());
        assertEquals(0, twinkle.getExtraNames().size());
        assertEquals(1, twinkle.getAttackMessages().size());
        assertEquals("エクスチェンジ！モードエレガント！\n" +
                "キラキラ、星よ！プリキュア・トゥインクル・ハミング！\n" +
                "(ドリーミング)\n" +
                "ごきげんよう",
                twinkle.getAttackMessages().get(0));
        assertEquals(List.of("princess_engage"),
                            twinkle.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(twinkle, Girl.byName("twinkle"));
    }

    @Test
    void 変身(){
        twinkle.humanize();

        assertEquals("天ノ川きらら", twinkle.name());
        twinkle.transform();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "きらめく星のプリンセス！キュアトゥインクル！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟はよろしくて？"),
                messageTester.messages);
        assertEquals("キュアトゥインクル", twinkle.name());

        messageTester.messages.clear();
        twinkle.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("天ノ川きらら", twinkle.name());

        messageTester.messages.clear();
        twinkle.princessEngage();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "きらめく星のプリンセス！キュアトゥインクル！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟はよろしくて？"),
                messageTester.messages);
        assertEquals("キュアトゥインクル", twinkle.name());

        messageTester.messages.clear();
        twinkle.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("天ノ川きらら", twinkle.name());
    }

    @Test
    void 攻撃(){
        twinkle.humanize();
        assertThrows(RequireTransformException.class, () -> twinkle.attack(), "Require transform.");

        twinkle.transform();
        messageTester.messages.clear();
        twinkle.attack();
        assertEquals(List.of("エクスチェンジ！モードエレガント！",
                "キラキラ、星よ！プリキュア・トゥインクル・ハミング！",
                "(ドリーミング)",
                "ごきげんよう"),
                messageTester.messages);
    }
}
