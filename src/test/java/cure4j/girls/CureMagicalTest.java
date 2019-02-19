package cure4j.girls;

import cure4j.util.LinkleStoneMiracleMagical;
import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureMagicalTest extends GirlTestBase {

    CureMagical magical = Cure.magical;

    @Test
    void 基本情報(){
        assertEquals("十六夜リコ", magical.humanName());
        assertEquals("十六夜リコ", magical.fullName());
        assertEquals("Undefined.", magical.humanFullName());
        assertEquals("堀江由衣", magical.castName());
        assertEquals("11/12", magical.birthday());
        assertEquals(0, magical.getExtraNames().size());
        assertEquals(4, magical.getAttackMessages().size());
        assertEquals("リンクルステッキ！\n" +
                "ダイヤ！永遠の輝きを私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・ダイヤモンド・エターナル！",
                magical.getAttackMessages().get(0));
        assertEquals("リンクルステッキ！\n" +
                "ルビー！紅の情熱よ私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・ルビー・パッショナーレ！",
                magical.getAttackMessages().get(1));
        assertEquals("リンクルステッキ！\n" +
                "サファイア！青き知性よ私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・サファイア・スマーティッシュ！",
                magical.getAttackMessages().get(2));
        assertEquals("リンクルステッキ！\n" +
                "トパーズ！金色の希望よ私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・トパーズ・エスペランサ！",
                magical.getAttackMessages().get(3));
        assertEquals(List.of("cure_up_rapapa"),
                            magical.getTransformCalls());
    }

    @Test
    void 基本情報_変身前(){
        magical.humanize();
        assertEquals("cure_magical", magical.girlName());
        assertEquals("キュアマジカル", magical.precureName());
        assertEquals(PrecureColor.PURPLE, magical.color());
        assertEquals(LocalDate.of(2016, 2, 7), magical.createdDate());
        assertEquals("", magical.getTransformMessage());
    }

    @Test
    void 基本情報_ダイヤ(){
        magical.transform(LinkleStoneMiracleMagical.DIAMOND);
        assertEquals("cure_magical_diamond", magical.girlName());
        assertEquals("キュアマジカル（ダイヤスタイル）", magical.precureName());
        assertEquals(PrecureColor.PURPLE, magical.color());
        assertEquals(LocalDate.of(2016, 2, 7), magical.createdDate());
        assertEquals("キュアップ・ラパパ！　ダイヤ！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの魔法！キュアマジカル！\n" +
                "魔法つかいプリキュア！！",
                magical.getTransformMessage());
    }

    @Test
    void 基本情報_ルビー(){
        magical.transform(LinkleStoneMiracleMagical.RUBY);
        assertEquals("cure_magical_ruby", magical.girlName());
        assertEquals("キュアマジカル（ルビースタイル）", magical.precureName());
        assertEquals(PrecureColor.RED, magical.color());
        assertEquals(LocalDate.of(2016, 2, 21), magical.createdDate());
        assertEquals("キュアップ・ラパパ！　ルビー！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの魔法！キュアマジカル！\n" +
                "魔法つかいプリキュア！！",
                magical.getTransformMessage());
    }

    @Test
    void 基本情報_サファイア(){
        magical.transform(LinkleStoneMiracleMagical.SAPPHIRE);
        assertEquals("cure_magical_sapphire", magical.girlName());
        assertEquals("キュアマジカル（サファイアスタイル）", magical.precureName());
        assertEquals(PrecureColor.BLUE, magical.color());
        assertEquals(LocalDate.of(2016, 3, 20), magical.createdDate());
        assertEquals("キュアップ・ラパパ！　サファイア！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの魔法！キュアマジカル！\n" +
                "魔法つかいプリキュア！！",
                magical.getTransformMessage());
    }

    @Test
    void 基本情報_トパーズ(){
        magical.transform(LinkleStoneMiracleMagical.TOPAZ);
        assertEquals("cure_magical_topaz", magical.girlName());
        assertEquals("キュアマジカル（トパーズスタイル）", magical.precureName());
        assertEquals(PrecureColor.YELLOW, magical.color());
        assertEquals(LocalDate.of(2016, 4, 17), magical.createdDate());
        assertEquals("キュアップ・ラパパ！　トパーズ！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの魔法！キュアマジカル！\n" +
                "魔法つかいプリキュア！！",
                magical.getTransformMessage());
    }

    @Test
    void エイリアス(){
        assertEquals(magical, Girl.byName("magical"));
    }

    @Test
    void 変身(){
        magical.humanize();

        assertEquals("十六夜リコ", magical.name());
        magical.cureUpRapapa(LinkleStoneMiracleMagical.DIAMOND);
        assertEquals(List.of("キュアップ・ラパパ！　ダイヤ！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの魔法！キュアマジカル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアマジカル（ダイヤスタイル）", magical.name());

        messageTester.messages.clear();
        magical.cureUpRapapa(LinkleStoneMiracleMagical.RUBY);
        assertEquals(List.of("キュアップ・ラパパ！　ルビー！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの魔法！キュアマジカル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアマジカル（ルビースタイル）", magical.name());

        messageTester.messages.clear();
        magical.cureUpRapapa(LinkleStoneMiracleMagical.SAPPHIRE);
        assertEquals(List.of("キュアップ・ラパパ！　サファイア！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの魔法！キュアマジカル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアマジカル（サファイアスタイル）", magical.name());

        messageTester.messages.clear();
        magical.cureUpRapapa(LinkleStoneMiracleMagical.TOPAZ);
        assertEquals(List.of("キュアップ・ラパパ！　トパーズ！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの魔法！キュアマジカル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアマジカル（トパーズスタイル）", magical.name());

        messageTester.messages.clear();
        magical.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("十六夜リコ", magical.name());
    }

    @Test
    void 攻撃(){
        magical.humanize();
        assertThrows(RequireTransformException.class, () -> magical.attack(), "Require transform.");

        magical.transform(LinkleStoneMiracleMagical.DIAMOND);
        messageTester.messages.clear();
        magical.attack();
        assertEquals(List.of("リンクルステッキ！",
                "ダイヤ！永遠の輝きを私達の手に！",
                "フルフルリンクル！",
                "プリキュア・ダイヤモンド・エターナル！"),
                messageTester.messages);

        magical.transform(LinkleStoneMiracleMagical.RUBY);
        messageTester.messages.clear();
        magical.attack();
        assertEquals(List.of("リンクルステッキ！",
                "ルビー！紅の情熱よ私達の手に！",
                "フルフルリンクル！",
                "プリキュア・ルビー・パッショナーレ！"),
                messageTester.messages);

        magical.transform(LinkleStoneMiracleMagical.SAPPHIRE);
        messageTester.messages.clear();
        magical.attack();
        assertEquals(List.of("リンクルステッキ！",
                "サファイア！青き知性よ私達の手に！",
                "フルフルリンクル！",
                "プリキュア・サファイア・スマーティッシュ！"),
                messageTester.messages);

        magical.transform(LinkleStoneMiracleMagical.TOPAZ);
        messageTester.messages.clear();
        magical.attack();
        assertEquals(List.of("リンクルステッキ！",
                "トパーズ！金色の希望よ私達の手に！",
                "フルフルリンクル！",
                "プリキュア・トパーズ・エスペランサ！"),
                messageTester.messages);
    }
}
