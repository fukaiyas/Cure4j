package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureCoralTest extends GirlTestBase {

    CureCoral coral = Cure.coral;

    @Test
    void 基本情報(){
        assertEquals("cure_coral", coral.girlName());
        assertEquals("涼村さんご", coral.humanName());
        assertEquals("涼村さんご", coral.fullName());
        assertEquals("Undefined.", coral.humanFullName());
        assertEquals("キュアコーラル", coral.precureName());
        assertEquals("花守ゆみり", coral.castName());
        assertEquals(LocalDate.of(2021, 3, 14), coral.createdDate());
        assertEquals(PrecureColor.PURPLE, coral.color());
        assertEquals("5/9", coral.birthday());
        assertEquals("""
                プリキュア！トロピカルチェンジ！
                レッツメイク！キャッチ！
                リップ！
                アイズ！
                ヘアー！
                チーク！
                ドレス！
                きらめく宝石！キュアコーラル！
                はぁー！
                ${random_transform_word}
                トロピカル～ジュ！プリキュア！""",
                coral.getTransformMessage());
        assertEquals(0, coral.getExtraNames().size());
        assertEquals(1, coral.getAttackMessages().size());
        assertEquals("""
                ハートルージュロッド！
                プリキュア！もこもこコーラルディフュージョン！
                ビクトリー！""",
                coral.getAttackMessages().get(0));
        assertEquals(List.of("tropical_change"),
                            coral.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(coral, Girl.byName("coral"));
    }

    @Test
    void 変身(){
        coral.humanize();

        assertEquals("涼村さんご", coral.name());
        coral.transform();
        TestUtil.assertVariableList(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "リップ！",
                "アイズ！",
                "ヘアー！",
                "チーク！",
                "ドレス！",
                "きらめく宝石！キュアコーラル！",
                "はぁー！",
                "*any*",
                "トロピカル～ジュ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアコーラル", coral.name());

        messageTester.messages.clear();
        coral.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("涼村さんご", coral.name());

        messageTester.messages.clear();
        coral.tropicalChange();
        TestUtil.assertVariableList(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "リップ！",
                "アイズ！",
                "ヘアー！",
                "チーク！",
                "ドレス！",
                "きらめく宝石！キュアコーラル！",
                "はぁー！",
                "*any*",
                "トロピカル～ジュ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアコーラル", coral.name());

        messageTester.messages.clear();
        coral.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("涼村さんご", coral.name());
    }

    @Test
    void 攻撃(){
        coral.humanize();
        assertThrows(RequireTransformException.class, () -> coral.attack(), "Require transform.");

        coral.transform();
        messageTester.messages.clear();
        coral.attack();
        assertEquals(List.of("ハートルージュロッド！",
                "プリキュア！もこもこコーラルディフュージョン！",
                "ビクトリー！"),
                messageTester.messages);
    }
}
