package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureFlamingoTest extends GirlTestBase {

    CureFlamingo flamingo = Cure.flamingo;

    @Test
    void 基本情報(){
        assertEquals("cure_flamingo", flamingo.girlName());
        assertEquals("滝沢あすか", flamingo.humanName());
        assertEquals("滝沢あすか", flamingo.fullName());
        assertEquals("Undefined.", flamingo.humanFullName());
        assertEquals("キュアフラミンゴ", flamingo.precureName());
        assertEquals("瀬戸麻沙美", flamingo.castName());
        assertEquals(LocalDate.of(2021, 3, 28), flamingo.createdDate());
        assertEquals(PrecureColor.RED, flamingo.color());
        assertEquals("10/15", flamingo.birthday());
        assertEquals("プリキュア！トロピカルチェンジ！\n" +
                "レッツメイク！キャッチ！\n" +
                "リップ！\n" +
                "チーク！\n" +
                "アイズ！\n" +
                "ヘアー！\n" +
                "ドレス！\n" +
                "はためく翼！キュアフラミンゴ！",
                flamingo.getTransformMessage());
        assertEquals(0, flamingo.getExtraNames().size());
        assertEquals(1, flamingo.getAttackMessages().size());
        assertEquals("ハートルージュロッド！\n" +
                "プリキュア！ぶっとびフラミンゴスマッシュ！\n" +
                "ビクトリー！",
                flamingo.getAttackMessages().get(0));
        assertEquals(List.of("precure_tropical_change"),
                            flamingo.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(flamingo, Girl.byName("flamingo"));
    }

    @Test
    void 変身(){
        flamingo.humanize();

        assertEquals("滝沢あすか", flamingo.name());
        flamingo.transform();
        assertEquals(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "リップ！",
                "チーク！",
                "アイズ！",
                "ヘアー！",
                "ドレス！",
                "はためく翼！キュアフラミンゴ！"),
                messageTester.messages);
        assertEquals("キュアフラミンゴ", flamingo.name());

        messageTester.messages.clear();
        flamingo.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("滝沢あすか", flamingo.name());

        messageTester.messages.clear();
        flamingo.tropicalChange();
        assertEquals(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "リップ！",
                "チーク！",
                "アイズ！",
                "ヘアー！",
                "ドレス！",
                "はためく翼！キュアフラミンゴ！"),
                messageTester.messages);
        assertEquals("キュアフラミンゴ", flamingo.name());

        messageTester.messages.clear();
        flamingo.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("滝沢あすか", flamingo.name());
    }

    @Test
    void 攻撃(){
        flamingo.humanize();
        assertThrows(RequireTransformException.class, () -> flamingo.attack(), "Require transform.");

        flamingo.transform();
        messageTester.messages.clear();
        flamingo.attack();
        assertEquals(List.of("ハートルージュロッド！",
                "プリキュア！ぶっとびフラミンゴスマッシュ！",
                "ビクトリー！"),
                messageTester.messages);
    }
}
