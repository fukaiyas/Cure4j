package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureScarletTest extends GirlTestBase {

    CureScarlet scarlet = Cure.scarlet;

    @Test
    void 基本情報(){
        assertEquals("cure_scarlet", scarlet.girlName());
        assertEquals("紅城トワ", scarlet.humanName());
        assertEquals("プリンセス・ホープ・ディライト・トワ", scarlet.fullName());
        assertEquals("プリンセス・ホープ・ディライト・トワ", scarlet.humanFullName());
        assertEquals("キュアスカーレット", scarlet.precureName());
        assertEquals("沢城みゆき", scarlet.castName());
        assertEquals(LocalDate.of(2015, 7, 5), scarlet.createdDate());
        assertEquals(PrecureColor.RED, scarlet.color());
        assertEquals("12/15", scarlet.birthday());
        assertEquals("プリキュア！プリンセスエンゲージ！\n" +
                "深紅の炎のプリンセス！キュアスカーレット！\n" +
                "強く、やさしく、美しく！\n" +
                "Go!プリンセスプリキュア！\n" +
                "冷たい檻に閉ざされた夢、返していただきますわ！\n" +
                "お覚悟決めなさい！",
                scarlet.getTransformMessage());
        assertEquals(0, scarlet.getExtraNames().size());
        assertEquals(1, scarlet.getAttackMessages().size());
        assertEquals("エクスチェンジ！モードエレガント！\n" +
                "羽ばたけ炎の翼！プリキュア・フェニックス・ブレイズ！\n" +
                "(ドリーミング)\n" +
                "ごきげんよう",
                scarlet.getAttackMessages().get(0));
        assertEquals(List.of("princess_engage"),
                            scarlet.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(scarlet, Girl.byName("scarlet"));
    }

    @Test
    void 変身(){
        scarlet.humanize();

        assertEquals("紅城トワ", scarlet.name());
        scarlet.transform();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "深紅の炎のプリンセス！キュアスカーレット！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟決めなさい！"),
                messageTester.messages);
        assertEquals("キュアスカーレット", scarlet.name());

        messageTester.messages.clear();
        scarlet.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("紅城トワ", scarlet.name());

        messageTester.messages.clear();
        scarlet.princessEngage();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "深紅の炎のプリンセス！キュアスカーレット！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟決めなさい！"),
                messageTester.messages);
        assertEquals("キュアスカーレット", scarlet.name());

        messageTester.messages.clear();
        scarlet.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("紅城トワ", scarlet.name());
    }

    @Test
    void 攻撃(){
        scarlet.humanize();
        assertThrows(RequireTransformException.class, () -> scarlet.attack(), "Require transform.");

        scarlet.transform();
        messageTester.messages.clear();
        scarlet.attack();
        assertEquals(List.of("エクスチェンジ！モードエレガント！",
                "羽ばたけ炎の翼！プリキュア・フェニックス・ブレイズ！",
                "(ドリーミング)",
                "ごきげんよう"),
                messageTester.messages);
    }
}
