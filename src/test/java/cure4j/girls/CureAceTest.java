package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureAceTest extends GirlTestBase {

    CureAce ace = Cure.ace;

    @Test
    void 基本情報(){
        System.out.println(Charset.defaultCharset());
        assertEquals("cure_ace", ace.girlName());
        assertEquals("円亜久里", ace.humanName());
        assertEquals("円亜久里", ace.fullName());
        assertEquals("Undefined.", ace.humanFullName());
        assertEquals("キュアエース", ace.precureName());
        assertEquals("釘宮理恵", ace.castName());
        assertEquals(LocalDate.of(2013, 6, 30), ace.createdDate());
        assertEquals(PrecureColor.RED, ace.color());
        assertFalse(ace.hasBirthday());
        assertEquals("プリキュアドレスアップ！\n" +
                "(キュピラッパー！)\n" +
                "愛の切り札！ キュアエース！\n" +
                "響け愛の鼓動！ドキドキプリキュア！\n" +
                "美しさは正義の証し、ウインク一つで、\n" +
                "あなたのハートを射抜いて差し上げますわ",
                ace.getTransformMessage());
        assertEquals(0, ace.getExtraNames().size());
        assertEquals(1, ace.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "ときめきなさい！エースショット！\n" +
                "ばきゅ〜ん！！"),
                ace.getAttackMessages().get(0));
        assertEquals(List.of("dress_up"),
                            ace.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(ace, Girl.byName("ace"));
    }

    @Test
    void 変身(){
        ace.humanize();

        assertEquals("円亜久里", ace.name());
        ace.transform();
        assertEquals(List.of("プリキュアドレスアップ！",
                "(キュピラッパー！)",
                "愛の切り札！ キュアエース！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "美しさは正義の証し、ウインク一つで、",
                "あなたのハートを射抜いて差し上げますわ"),
                messageTester.messages);
        assertEquals("キュアエース", ace.name());

        messageTester.messages.clear();
        ace.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("円亜久里", ace.name());

        messageTester.messages.clear();
        ace.dressUp();
        assertEquals(List.of("プリキュアドレスアップ！",
                "(キュピラッパー！)",
                "愛の切り札！ キュアエース！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "美しさは正義の証し、ウインク一つで、",
                "あなたのハートを射抜いて差し上げますわ"),
                messageTester.messages);
        assertEquals("キュアエース", ace.name());

        messageTester.messages.clear();
        ace.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("円亜久里", ace.name());
    }

    @Test
    void 攻撃(){
        ace.humanize();
        assertThrows(RequireTransformException.class, () -> ace.attack(), "Require transform.");

        ace.transform();
        messageTester.messages.clear();
        ace.attack();
        assertEquals(List.of("ときめきなさい！エースショット！",
                TestUtil.waveDash2FullwidthTilde("ばきゅ〜ん！！")),
                messageTester.messages);
    }
}
