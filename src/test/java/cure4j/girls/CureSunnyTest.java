package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureSunnyTest extends GirlTestBase {

    CureSunny sunny = Cure.sunny;

    @Test
    void 基本情報(){
        assertEquals("cure_sunny", sunny.girlName());
        assertEquals("日野あかね", sunny.humanName());
        assertEquals("日野あかね", sunny.fullName());
        assertEquals("Undefined.", sunny.humanFullName());
        assertEquals("キュアサニー", sunny.precureName());
        assertEquals("田野アサミ", sunny.castName());
        assertEquals(LocalDate.of(2012, 2, 12), sunny.createdDate());
        assertEquals(PrecureColor.RED, sunny.color());
        assertFalse(sunny.hasBirthday());
        assertEquals("(レディ？)\n" +
                "プリキュア・スマイルチャージ！\n" +
                "(ゴー！ゴー！レッツ・ゴー！サニー！！)\n" +
                "太陽サンサン熱血パワー！ キュアサニー！\n" +
                "5つの光が導く未来！\n" +
                "輝け！スマイルプリキュア！",
                sunny.getTransformMessage());
        assertEquals(List.of("プリンセスサニー", "ウルトラサニー"), sunny.getExtraNames());
        assertEquals(3, sunny.getAttackMessages().size());
        assertEquals("プリキュア！サニーファイヤー！！",
                sunny.getAttackMessages().get(0));
        assertEquals("開け、ロイヤルクロック！\n" +
                "(みんなの力を1つにするクル！)\n" +
                "届け、希望の光！\n" +
                "はばたけ！光り輝く未来へ！\n" +
                "プリキュア！ロイヤルレインボーバースト！",
                sunny.getAttackMessages().get(1));
        assertEquals("(みんなの力を1つにするクル！)\n" +
                "プリキュア！ミラクルレインボーバースト！\n" +
                "輝けー！！\n" +
                "スマイルプリキュア！！",
                sunny.getAttackMessages().get(2));
        assertEquals(List.of("smile_charge"),
                            sunny.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(sunny, Girl.byName("sunny"));
    }

    @Test
    void 変身(){
        sunny.humanize();

        assertEquals("日野あかね", sunny.name());
        sunny.transform();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！サニー！！)",
                "太陽サンサン熱血パワー！ キュアサニー！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアサニー", sunny.name());

        messageTester.messages.clear();
        sunny.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリンセスサニー", sunny.name());

        messageTester.messages.clear();
        sunny.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ウルトラサニー", sunny.name());

        messageTester.messages.clear();
        sunny.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("日野あかね", sunny.name());

        messageTester.messages.clear();
        sunny.smileCharge();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！サニー！！)",
                "太陽サンサン熱血パワー！ キュアサニー！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアサニー", sunny.name());

        messageTester.messages.clear();
        sunny.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("日野あかね", sunny.name());
    }

    @Test
    void 攻撃(){
        sunny.humanize();
        assertThrows(RequireTransformException.class, () -> sunny.attack(), "Require transform.");

        sunny.transform();
        messageTester.messages.clear();
        sunny.attack();
        assertEquals(List.of("プリキュア！サニーファイヤー！！"),
                messageTester.messages);

        sunny.transform();
        messageTester.messages.clear();
        sunny.attack();
        assertEquals(List.of("開け、ロイヤルクロック！",
                "(みんなの力を1つにするクル！)",
                "届け、希望の光！",
                "はばたけ！光り輝く未来へ！",
                "プリキュア！ロイヤルレインボーバースト！"),
                messageTester.messages);

        sunny.transform();
        messageTester.messages.clear();
        sunny.attack();
        assertEquals(List.of("(みんなの力を1つにするクル！)",
                "プリキュア！ミラクルレインボーバースト！",
                "輝けー！！",
                "スマイルプリキュア！！"),
                messageTester.messages);
    }
}
