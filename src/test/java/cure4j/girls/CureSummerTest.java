package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureSummerTest extends GirlTestBase {

    CureSummer summer = Cure.summer;

    @Test
    void 基本情報(){
        assertEquals("cure_summer", summer.girlName());
        assertEquals("夏海まなつ", summer.humanName());
        assertEquals("夏海まなつ", summer.fullName());
        assertEquals("Undefined.", summer.humanFullName());
        assertEquals("キュアサマー", summer.precureName());
        assertEquals("ファイルーズあい", summer.castName());
        assertEquals(LocalDate.of(2021, 2, 28), summer.createdDate());
        assertEquals(PrecureColor.WHITE, summer.color());
        assertEquals("8/1", summer.birthday());
        assertEquals("プリキュア！トロピカルチェンジ！\n" +
                "レッツメイク！キャッチ！\n" +
                "チーク！\n" +
                "アイズ！\n" +
                "ヘアー！\n" +
                "リップ！\n" +
                "ドレス！\n" +
                "ときめく常夏！キュアサマー！\n" +
                "はぁー！\n" +
                "4人揃って！トロピカル～ジュ！プリキュア！",
                summer.getTransformMessage());
        assertEquals(0, summer.getExtraNames().size());
        assertEquals(1, summer.getAttackMessages().size());
        assertEquals("ハートルージュロッド！\n" +
                "プリキュア！おてんとサマーストライク！\n" +
                "ビクトリー！",
                summer.getAttackMessages().get(0));
        assertEquals(List.of("precure_tropical_change"),
                            summer.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(summer, Girl.byName("summer"));
    }

    @Test
    void 変身(){
        summer.humanize();

        assertEquals("夏海まなつ", summer.name());
        summer.transform();
        assertEquals(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "チーク！",
                "アイズ！",
                "ヘアー！",
                "リップ！",
                "ドレス！",
                "ときめく常夏！キュアサマー！",
                "はぁー！",
                "4人揃って！トロピカル～ジュ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアサマー", summer.name());

        messageTester.messages.clear();
        summer.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夏海まなつ", summer.name());

        messageTester.messages.clear();
        summer.tropicalChange();
        assertEquals(List.of("プリキュア！トロピカルチェンジ！",
                "レッツメイク！キャッチ！",
                "チーク！",
                "アイズ！",
                "ヘアー！",
                "リップ！",
                "ドレス！",
                "ときめく常夏！キュアサマー！",
                "はぁー！",
                "4人揃って！トロピカル～ジュ！プリキュア！"),
                messageTester.messages);
        assertEquals("キュアサマー", summer.name());

        messageTester.messages.clear();
        summer.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夏海まなつ", summer.name());
    }

    @Test
    void 攻撃(){
        summer.humanize();
        assertThrows(RequireTransformException.class, () -> summer.attack(), "Require transform.");

        summer.transform();
        messageTester.messages.clear();
        summer.attack();
        assertEquals(List.of("ハートルージュロッド！",
                "プリキュア！おてんとサマーストライク！",
                "ビクトリー！"),
                messageTester.messages);
    }
}
