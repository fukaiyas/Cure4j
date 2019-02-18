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

public class CureMiracleTest extends GirlTestBase {

    CureMiracle miracle = Cure.miracle;

    @Test
    void 基本情報(){
        assertEquals("朝日奈みらい", miracle.humanName());
        assertEquals("朝日奈みらい", miracle.fullName());
        assertEquals("Undefined.", miracle.humanFullName());
        assertEquals("高橋李依", miracle.castName());
        assertEquals("6/12", miracle.birthday());
        assertEquals(0, miracle.getExtraNames().size());
        assertEquals(4, miracle.getAttackMessages().size());
        assertEquals("リンクルステッキ！\n" +
                "ダイヤ！永遠の輝きを私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・ダイヤモンド・エターナル！",
                miracle.getAttackMessages().get(0));
        assertEquals("リンクルステッキ！\n" +
                "ルビー！紅の情熱よ私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・ルビー・パッショナーレ！",
                miracle.getAttackMessages().get(1));
        assertEquals("リンクルステッキ！\n" +
                "サファイア！青き知性よ私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・サファイア・スマーティッシュ！",
                miracle.getAttackMessages().get(2));
        assertEquals("リンクルステッキ！\n" +
                "トパーズ！金色の希望よ私達の手に！\n" +
                "フルフルリンクル！\n" +
                "プリキュア・トパーズ・エスペランサ！",
                miracle.getAttackMessages().get(3));
        assertEquals(List.of("cure_up_rapapa"),
                            miracle.getTransformCalls());
    }

    @Test
    void 基本情報_変身前(){
        miracle.humanize();
        assertEquals("cure_miracle", miracle.girlName());
        assertEquals("キュアミラクル", miracle.precureName());
        assertEquals(PrecureColor.PINK, miracle.color());
        assertEquals(LocalDate.of(2016, 2, 7), miracle.createdDate());
        assertEquals("", miracle.getTransformMessage());
    }

    @Test
    void 基本情報_ダイヤ(){
        miracle.transform(LinkleStoneMiracleMagical.DIAMOND);
        assertEquals("cure_miracle_diamond", miracle.girlName());
        assertEquals("キュアミラクル（ダイヤスタイル）", miracle.precureName());
        assertEquals(PrecureColor.PINK, miracle.color());
        assertEquals(LocalDate.of(2016, 2, 7), miracle.createdDate());
        assertEquals("キュアップ・ラパパ！　ダイヤ！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの奇跡！キュアミラクル！\n" +
                "魔法つかいプリキュア！！",
                miracle.getTransformMessage());
    }

    @Test
    void 基本情報_ルビー(){
        miracle.transform(LinkleStoneMiracleMagical.RUBY);
        assertEquals("cure_miracle_ruby", miracle.girlName());
        assertEquals("キュアミラクル（ルビースタイル）", miracle.precureName());
        assertEquals(PrecureColor.RED, miracle.color());
        assertEquals(LocalDate.of(2016, 2, 21), miracle.createdDate());
        assertEquals("キュアップ・ラパパ！　ルビー！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの奇跡！キュアミラクル！\n" +
                "魔法つかいプリキュア！！",
                miracle.getTransformMessage());
    }

    @Test
    void 基本情報_サファイア(){
        miracle.transform(LinkleStoneMiracleMagical.SAPPHIRE);
        assertEquals("cure_miracle_sapphire", miracle.girlName());
        assertEquals("キュアミラクル（サファイアスタイル）", miracle.precureName());
        assertEquals(PrecureColor.BLUE, miracle.color());
        assertEquals(LocalDate.of(2016, 3, 20), miracle.createdDate());
        assertEquals("キュアップ・ラパパ！　サファイア！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの奇跡！キュアミラクル！\n" +
                "魔法つかいプリキュア！！",
                miracle.getTransformMessage());
    }

    @Test
    void 基本情報_トパーズ(){
        miracle.transform(LinkleStoneMiracleMagical.TOPAZ);
        assertEquals("cure_miracle_topaz", miracle.girlName());
        assertEquals("キュアミラクル（トパーズスタイル）", miracle.precureName());
        assertEquals(PrecureColor.YELLOW, miracle.color());
        assertEquals(LocalDate.of(2016, 4, 17), miracle.createdDate());
        assertEquals("キュアップ・ラパパ！　トパーズ！\n" +
                "ミラクル・マジカル・ジュエリーレ！\n" +
                "ふたりの奇跡！キュアミラクル！\n" +
                "魔法つかいプリキュア！！",
                miracle.getTransformMessage());
    }

    @Test
    void エイリアス(){
        assertEquals(miracle, Girl.byName("miracle"));
    }

    @Test
    void 変身(){
        miracle.humanize();

        assertEquals("朝日奈みらい", miracle.name());
        miracle.cureUpRapapa(LinkleStoneMiracleMagical.DIAMOND);
        assertEquals(List.of("キュアップ・ラパパ！　ダイヤ！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの奇跡！キュアミラクル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアミラクル（ダイヤスタイル）", miracle.name());

        messageTester.messages.clear();
        miracle.cureUpRapapa(LinkleStoneMiracleMagical.RUBY);
        assertEquals(List.of("キュアップ・ラパパ！　ルビー！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの奇跡！キュアミラクル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアミラクル（ルビースタイル）", miracle.name());

        messageTester.messages.clear();
        miracle.cureUpRapapa(LinkleStoneMiracleMagical.SAPPHIRE);
        assertEquals(List.of("キュアップ・ラパパ！　サファイア！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの奇跡！キュアミラクル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアミラクル（サファイアスタイル）", miracle.name());

        messageTester.messages.clear();
        miracle.cureUpRapapa(LinkleStoneMiracleMagical.TOPAZ);
        assertEquals(List.of("キュアップ・ラパパ！　トパーズ！",
                "ミラクル・マジカル・ジュエリーレ！",
                "ふたりの奇跡！キュアミラクル！",
                "魔法つかいプリキュア！！"),
                messageTester.messages);
        assertEquals("キュアミラクル（トパーズスタイル）", miracle.name());

        messageTester.messages.clear();
        miracle.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("朝日奈みらい", miracle.name());
    }

    @Test
    void 攻撃(){
        miracle.humanize();
        assertThrows(RequireTransformException.class, () -> miracle.attack(), "Require transform.");

        miracle.transform(LinkleStoneMiracleMagical.DIAMOND);
        messageTester.messages.clear();
        miracle.attack();
        assertEquals(List.of("リンクルステッキ！",
                "ダイヤ！永遠の輝きを私達の手に！",
                "フルフルリンクル！",
                "プリキュア・ダイヤモンド・エターナル！"),
                messageTester.messages);

        miracle.transform(LinkleStoneMiracleMagical.RUBY);
        messageTester.messages.clear();
        miracle.attack();
        assertEquals(List.of("リンクルステッキ！",
                "ルビー！紅の情熱よ私達の手に！",
                "フルフルリンクル！",
                "プリキュア・ルビー・パッショナーレ！"),
                messageTester.messages);

        miracle.transform(LinkleStoneMiracleMagical.SAPPHIRE);
        messageTester.messages.clear();
        miracle.attack();
        assertEquals(List.of("リンクルステッキ！",
                "サファイア！青き知性よ私達の手に！",
                "フルフルリンクル！",
                "プリキュア・サファイア・スマーティッシュ！"),
                messageTester.messages);

        miracle.transform(LinkleStoneMiracleMagical.TOPAZ);
        messageTester.messages.clear();
        miracle.attack();
        assertEquals(List.of("リンクルステッキ！",
                "トパーズ！金色の希望よ私達の手に！",
                "フルフルリンクル！",
                "プリキュア・トパーズ・エスペランサ！"),
                messageTester.messages);
    }
}
