package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureMermaidTest extends GirlTestBase {

    CureMermaid mermaid = Cure.mermaid;

    @Test
    void 基本情報(){
        assertEquals("cure_mermaid", mermaid.girlName());
        assertEquals("海藤みなみ", mermaid.humanName());
        assertEquals("海藤みなみ", mermaid.fullName());
        assertEquals("Undefined.", mermaid.humanFullName());
        assertEquals("キュアマーメイド", mermaid.precureName());
        assertEquals("浅野真澄", mermaid.castName());
        assertEquals(LocalDate.of(2015, 2, 8), mermaid.createdDate());
        assertEquals(PrecureColor.BLUE, mermaid.color());
        assertEquals("7/20", mermaid.birthday());
        assertEquals("プリキュア！プリンセスエンゲージ！\n" +
                "澄み渡る海のプリンセス！キュアマーメイド！\n" +
                "強く、やさしく、美しく！\n" +
                "Go!プリンセスプリキュア！\n" +
                "冷たい檻に閉ざされた夢、返していただきますわ！\n" +
                "お覚悟はよろしくて？",
                mermaid.getTransformMessage());
        assertEquals(0, mermaid.getExtraNames().size());
        assertEquals(1, mermaid.getAttackMessages().size());
        assertEquals("エクスチェンジ！モードエレガント！\n" +
                "高鳴れ、海よ！プリキュア・マーメイド・リップル！\n" +
                "(ドリーミング)\n" +
                "ごきげんよう",
                mermaid.getAttackMessages().get(0));
        assertEquals(List.of("princess_engage"),
                            mermaid.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(mermaid, Girl.byName("mermaid"));
    }

    @Test
    void 変身(){
        mermaid.humanize();

        assertEquals("海藤みなみ", mermaid.name());
        mermaid.transform();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "澄み渡る海のプリンセス！キュアマーメイド！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟はよろしくて？"),
                messageTester.messages);
        assertEquals("キュアマーメイド", mermaid.name());

        messageTester.messages.clear();
        mermaid.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("海藤みなみ", mermaid.name());

        messageTester.messages.clear();
        mermaid.princessEngage();
        assertEquals(List.of("プリキュア！プリンセスエンゲージ！",
                "澄み渡る海のプリンセス！キュアマーメイド！",
                "強く、やさしく、美しく！",
                "Go!プリンセスプリキュア！",
                "冷たい檻に閉ざされた夢、返していただきますわ！",
                "お覚悟はよろしくて？"),
                messageTester.messages);
        assertEquals("キュアマーメイド", mermaid.name());

        messageTester.messages.clear();
        mermaid.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("海藤みなみ", mermaid.name());
    }

    @Test
    void 攻撃(){
        mermaid.humanize();
        assertThrows(RequireTransformException.class, () -> mermaid.attack(), "Require transform.");

        mermaid.transform();
        messageTester.messages.clear();
        mermaid.attack();
        assertEquals(List.of("エクスチェンジ！モードエレガント！",
                "高鳴れ、海よ！プリキュア・マーメイド・リップル！",
                "(ドリーミング)",
                "ごきげんよう"),
                messageTester.messages);
    }
}
