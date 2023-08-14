package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureFinaleTest extends GirlTestBase {

    CureFinale finale = Cure.finale;

    @Test
    void 基本情報(){
        assertEquals("cure_finale", finale.girlName());
        assertEquals("菓彩あまね", finale.humanName());
        assertEquals("菓彩あまね", finale.fullName());
        assertEquals("Undefined.", finale.humanFullName());
        assertEquals("キュアフィナーレ", finale.precureName());
        assertEquals("茅野愛衣", finale.castName());
        assertEquals(LocalDate.of(2022, 7, 10), finale.createdDate());
        assertEquals(PrecureColor.GOLD, finale.color());
        assertTrue(finale.hasBirthday());
        assertEquals("11/24", finale.birthday());
        assertEquals(
                "プリキュア！デリシャスタンバイ！\n" +
                "Party Go!\n" +
                "フルーツ！\n" +
                "ファビュラスオーダー！\n" +
                "シェアリングエナジー！\n" +
                "トッピング！\n" +
                "ブリリアント！\n" +
                "シャインモア！\n" +
                "ジェントルにゴージャスに\n" +
                "咲き誇るスウィートネス！\n" +
                "キュアフィナーレ！\n" +
                "食卓の最後を、このわたしが飾ろう\n" +
                "デリシャスパーティ♡プリキュア！",
                finale.getTransformMessage());
        assertEquals(0, finale.getExtraNames().size());
        assertEquals(1, finale.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "クリーミーフルーレ！\n" +
                "ブルーミン・ダンシングフルーツ！\n" +
                "プリキュア！デリシャスフィナーレ・ファンファーレ！\n" +
                "お腹いっぱい\n" +
                "ごちそうさまでした！"),
                finale.getAttackMessages().get(0));
        assertEquals(List.of("delicioustandby"),
                            finale.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(finale, Girl.byName("finale"));
    }

    @Test
    void 変身(){
        finale.humanize();

        assertEquals("菓彩あまね", finale.name());
        finale.transform();
        assertEquals(List.of(
                "プリキュア！デリシャスタンバイ！",
                "Party Go!",
                "フルーツ！",
                "ファビュラスオーダー！",
                "シェアリングエナジー！",
                "トッピング！",
                "ブリリアント！",
                "シャインモア！",
                "ジェントルにゴージャスに",
                "咲き誇るスウィートネス！",
                "キュアフィナーレ！",
                "食卓の最後を、このわたしが飾ろう",
                "デリシャスパーティ♡プリキュア！"),
                messageTester.messages);
        assertEquals("キュアフィナーレ", finale.name());

        messageTester.messages.clear();
        finale.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("菓彩あまね", finale.name());

        messageTester.messages.clear();
        finale.delicioustandby();
        assertEquals(List.of(
                "プリキュア！デリシャスタンバイ！",
                "Party Go!",
                "フルーツ！",
                "ファビュラスオーダー！",
                "シェアリングエナジー！",
                "トッピング！",
                "ブリリアント！",
                "シャインモア！",
                "ジェントルにゴージャスに",
                "咲き誇るスウィートネス！",
                "キュアフィナーレ！",
                "食卓の最後を、このわたしが飾ろう",
                "デリシャスパーティ♡プリキュア！"),
                messageTester.messages);
        assertEquals("キュアフィナーレ", finale.name());

        messageTester.messages.clear();
        finale.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("菓彩あまね", finale.name());
    }

    @Test
    void 攻撃(){
        finale.humanize();
        assertThrows(RequireTransformException.class, () -> finale.attack(), "Require transform.");

        finale.transform();
        messageTester.messages.clear();
        finale.attack();
        assertEquals(List.of("クリーミーフルーレ！",
                "ブルーミン・ダンシングフルーツ！",
                "プリキュア！デリシャスフィナーレ・ファンファーレ！",
                "お腹いっぱい",
                "ごちそうさまでした！"),
                messageTester.messages);
    }
}
