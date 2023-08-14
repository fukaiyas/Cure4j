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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CureSpicyTest extends GirlTestBase {

    CureSpicy spicy = Cure.spicy;

    @Test
    void 基本情報(){
        assertEquals("cure_spicy", spicy.girlName());
        assertEquals("芙羽ここね", spicy.humanName());
        assertEquals("芙羽ここね", spicy.fullName());
        assertEquals("Undefined.", spicy.humanFullName());
        assertEquals("キュアスパイシー", spicy.precureName());
        assertEquals("清水理沙", spicy.castName());
        assertEquals(LocalDate.of(2022, 2, 27), spicy.createdDate());
        assertEquals(PrecureColor.BLUE, spicy.color());
        assertTrue(spicy.hasBirthday());
        assertEquals("3/13", spicy.birthday());
        assertEquals("パム！\n" +
                "プリキュア！デリシャスタンバイ！\n" +
                "Party Go!\n" +
                "オープン\n" +
                "パム！\n" +
                "サンド！\n" +
                "パムパム！\n" +
                "シェアリングエナジー！\n" +
                "テイスティー！\n" +
                "パムパム！\n" +
                "ふわふわサンドde心にスパイス！\n" +
                "キュアスパイシー！\n" +
                "わけあうおいしさ、焼きつけるわ！\n" +
                "デリシャスパーティ♡プリキュア！",
                spicy.getTransformMessage());
        assertEquals(0, spicy.getExtraNames().size());
        assertEquals(1, spicy.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "プリキュア！スパイシーサークル！\n" +
                "はー！\n" +
                "はー！\n" +
                "お腹いっぱい\n" +
                "ごちそうさまでした！"),
                spicy.getAttackMessages().get(0));
        assertEquals(List.of("delicioustandby"),
                            spicy.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(spicy, Girl.byName("spicy"));
    }

    @Test
    void 変身(){
        spicy.humanize();

        assertEquals("芙羽ここね", spicy.name());
        spicy.transform();
        assertEquals(List.of("パム！",
                "プリキュア！デリシャスタンバイ！",
                "Party Go!",
                "オープン",
                "パム！",
                "サンド！",
                "パムパム！",
                "シェアリングエナジー！",
                "テイスティー！",
                "パムパム！",
                "ふわふわサンドde心にスパイス！",
                "キュアスパイシー！",
                "わけあうおいしさ、焼きつけるわ！",
                "デリシャスパーティ♡プリキュア！"),
                messageTester.messages);
        assertEquals("キュアスパイシー", spicy.name());

        messageTester.messages.clear();
        spicy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("芙羽ここね", spicy.name());

        messageTester.messages.clear();
        spicy.delicioustandby();
        assertEquals(List.of("パム！",
                "プリキュア！デリシャスタンバイ！",
                "Party Go!",
                "オープン",
                "パム！",
                "サンド！",
                "パムパム！",
                "シェアリングエナジー！",
                "テイスティー！",
                "パムパム！",
                "ふわふわサンドde心にスパイス！",
                "キュアスパイシー！",
                "わけあうおいしさ、焼きつけるわ！",
                "デリシャスパーティ♡プリキュア！"),
                messageTester.messages);
        assertEquals("キュアスパイシー", spicy.name());

        messageTester.messages.clear();
        spicy.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("芙羽ここね", spicy.name());
    }

    @Test
    void 攻撃(){
        spicy.humanize();
        assertThrows(RequireTransformException.class, () -> spicy.attack(), "Require transform.");

        spicy.transform();
        messageTester.messages.clear();
        spicy.attack();
        assertEquals(List.of("プリキュア！スパイシーサークル！",
                "はー！",
                "はー！",
                "お腹いっぱい",
                "ごちそうさまでした！"),
                messageTester.messages);
    }
}
