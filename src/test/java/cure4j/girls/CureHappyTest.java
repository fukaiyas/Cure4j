package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureHappyTest extends GirlTestBase {

    CureHappy happy = Cure.happy;

    @Test
    void 基本情報(){
        assertEquals("cure_happy", happy.girlName());
        assertEquals("星空みゆき", happy.humanName());
        assertEquals("星空みゆき", happy.fullName());
        assertEquals("Undefined.", happy.humanFullName());
        assertEquals("キュアハッピー", happy.precureName());
        assertEquals("福圓美里", happy.castName());
        assertEquals(LocalDate.of(2012, 2, 5), happy.createdDate());
        assertEquals(PrecureColor.PINK, happy.color());
        assertFalse(happy.hasBirthday());
        assertEquals("(レディ？)\n" +
                "プリキュア・スマイルチャージ！\n" +
                "(ゴー！ゴー！レッツ・ゴー！ハッピー！！)\n" +
                "キラキラ輝く未来の光！ キュアハッピー！\n" +
                "5つの光が導く未来！\n" +
                "輝け！スマイルプリキュア！",
                happy.getTransformMessage());
        assertEquals(List.of("プリンセスハッピー", "ウルトラハッピー"), happy.getExtraNames());
        assertEquals(3, happy.getAttackMessages().size());
        assertEquals("プリキュア！ハッピーシャワー！！",
                happy.getAttackMessages().get(0));
        assertEquals("開け、ロイヤルクロック！\n" +
                "(みんなの力を1つにするクル！)\n" +
                "届け、希望の光！\n" +
                "はばたけ！光り輝く未来へ！\n" +
                "プリキュア！ロイヤルレインボーバースト！",
                happy.getAttackMessages().get(1));
        assertEquals("(みんなの力を1つにするクル！)\n" +
                "プリキュア！ミラクルレインボーバースト！\n" +
                "輝けー！！\n" +
                "スマイルプリキュア！！",
                happy.getAttackMessages().get(2));
        assertEquals(List.of("smile_charge"),
                            happy.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(happy, Girl.byName("happy"));
    }

    @Test
    void 変身(){
        happy.humanize();

        assertEquals("星空みゆき", happy.name());
        happy.transform();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！ハッピー！！)",
                "キラキラ輝く未来の光！ キュアハッピー！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアハッピー", happy.name());

        messageTester.messages.clear();
        happy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリンセスハッピー", happy.name());

        messageTester.messages.clear();
        happy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ウルトラハッピー", happy.name());

        messageTester.messages.clear();
        happy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("星空みゆき", happy.name());

        messageTester.messages.clear();
        happy.smileCharge();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！ハッピー！！)",
                "キラキラ輝く未来の光！ キュアハッピー！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアハッピー", happy.name());

        messageTester.messages.clear();
        happy.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("星空みゆき", happy.name());
    }

    @Test
    void 攻撃(){
        happy.humanize();
        assertThrows(RequireTransformException.class, () -> happy.attack(), "Require transform.");

        happy.transform();
        messageTester.messages.clear();
        happy.attack();
        assertEquals(List.of("プリキュア！ハッピーシャワー！！"),
                messageTester.messages);

        happy.transform();
        messageTester.messages.clear();
        happy.attack();
        assertEquals(List.of("開け、ロイヤルクロック！",
                "(みんなの力を1つにするクル！)",
                "届け、希望の光！",
                "はばたけ！光り輝く未来へ！",
                "プリキュア！ロイヤルレインボーバースト！"),
                messageTester.messages);

        happy.transform();
        messageTester.messages.clear();
        happy.attack();
        assertEquals(List.of("(みんなの力を1つにするクル！)",
                "プリキュア！ミラクルレインボーバースト！",
                "輝けー！！",
                "スマイルプリキュア！！"),
                messageTester.messages);
    }
}
