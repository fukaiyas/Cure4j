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

public class CureLamerTest extends GirlTestBase {

    CureLamer lamer = Cure.lamer;

    @Test
    void 基本情報(){
        assertEquals("cure_lamer", lamer.girlName());
        assertEquals("ローラ・ラメール", lamer.humanName());
        assertEquals("ローラ・アポロドーロス・ヒュギーヌス・ラメール", lamer.fullName());
        assertEquals("ローラ・アポロドーロス・ヒュギーヌス・ラメール", lamer.humanFullName());
        assertEquals("キュアラメール", lamer.precureName());
        assertEquals("日高里菜", lamer.castName());
        assertEquals(LocalDate.of(2021, 6, 20), lamer.createdDate());
        assertEquals(PrecureColor.BLUE, lamer.color());
        assertEquals("6/30", lamer.birthday());
        assertEquals("""
                プリキュア！トロピカルチェンジ！
                レッツメイク！キャッチ！
                フェイス！
                ネイル！
                ドレス！
                ゆらめく大海原！キュアラメール！
                はぁー！
                ${random_transform_word}
                トロピカル～ジュ！プリキュア！""",
                lamer.getTransformMessage());
        assertEquals(0, lamer.getExtraNames().size());
        assertEquals(1, lamer.getAttackMessages().size());
        assertEquals("""
                プリキュア！くるくるラメールストリーム！
                ビクトリー！""",
                lamer.getAttackMessages().get(0));
        assertEquals(List.of("tropical_change"),
                            lamer.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(lamer, Girl.byName("lamer"));
    }

    @Test
    void 変身(){
        lamer.humanize();

        assertEquals("ローラ・ラメール", lamer.name());
        lamer.transform();
        TestUtil.assertVariableList(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "フェイス！",
                "ネイル！",
                "ドレス！",
                "ゆらめく大海原！キュアラメール！",
                "はぁー！",
                "*any*",
                "トロピカル～ジュ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアラメール", lamer.name());

        messageTester.messages.clear();
        lamer.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ローラ・ラメール", lamer.name());

        messageTester.messages.clear();
        lamer.tropicalChange();
        TestUtil.assertVariableList(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "フェイス！",
                "ネイル！",
                "ドレス！",
                "ゆらめく大海原！キュアラメール！",
                "はぁー！",
                "*any*",
                "トロピカル～ジュ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアラメール", lamer.name());

        messageTester.messages.clear();
        lamer.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ローラ・ラメール", lamer.name());
    }

    @Test
    void 攻撃(){
        lamer.humanize();
        assertThrows(RequireTransformException.class, () -> lamer.attack(), "Require transform.");

        lamer.transform();
        messageTester.messages.clear();
        lamer.attack();
        assertEquals(List.of("プリキュア！くるくるラメールストリーム！",
                "ビクトリー！"),
                messageTester.messages);
    }
}
