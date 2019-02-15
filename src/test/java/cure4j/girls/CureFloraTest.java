package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureFloraTest extends GirlTestBase {

    CureFlora flora = Cure.flora;

    @Test
    void 基本情報(){
        assertEquals("cure_flora", flora.girlName());
        assertEquals("春野はるか", flora.humanName());
        assertEquals("春野はるか", flora.fullName());
        assertEquals("Undefined.", flora.humanFullName());
        assertEquals("キュアフローラ", flora.precureName());
        assertEquals("嶋村侑", flora.castName());
        assertEquals(LocalDate.of(2015, 2, 1), flora.createdDate());
        assertEquals(PrecureColor.PINK, flora.color());
        assertEquals("4/10", flora.birthday());
        assertEquals("プリキュア！プリンセスエンゲージ！\n" +
                "咲き誇る花のプリンセス！キュアフローラ！\n" +
                "強く、やさしく、美しく！\n" +
                "Go!プリンセスプリキュア！\n" +
                "冷たい檻に閉ざされた夢、返していただきますわ！\n" +
                "お覚悟はよろしくて？",
                flora.getTransformMessage());
        assertEquals(0, flora.getExtraNames().size());
        assertEquals(1, flora.getAttackMessages().size());
        assertEquals("エクスチェンジ！モードエレガント！\n" +
                "舞え、花よ！プリキュア・フローラル・トルビヨン！\n" +
                "(ドリーミング)\n" +
                "ごきげんよう",
                flora.getAttackMessages().get(0));
        assertEquals(List.of("princess_engage"),
                            flora.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(flora, Girl.byName("flora"));
    }

    @Test
    void 変身(){
        flora.humanize();

        assertEquals("春野はるか", flora.name());
        flora.transform();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "咲き誇る花のプリンセス！キュアフローラ！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟はよろしくて？"),
                messageTester.messages);
        assertEquals("キュアフローラ", flora.name());

        messageTester.messages.clear();
        flora.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("春野はるか", flora.name());

        messageTester.messages.clear();
        flora.princessEngage();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "咲き誇る花のプリンセス！キュアフローラ！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟はよろしくて？"),
                messageTester.messages);
        assertEquals("キュアフローラ", flora.name());

        messageTester.messages.clear();
        flora.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("春野はるか", flora.name());
    }

    @Test
    void 攻撃(){
        flora.humanize();
        assertThrows(RequireTransformException.class, () -> flora.attack(), "Require transform.");

        flora.transform();
        messageTester.messages.clear();
        flora.attack();
        assertEquals(List.of("エクスチェンジ！モードエレガント！",
                "舞え、花よ！プリキュア・フローラル・トルビヨン！",
                "(ドリーミング)",
                "ごきげんよう"),
                messageTester.messages);
    }
}
