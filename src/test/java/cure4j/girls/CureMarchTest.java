package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureMarchTest extends GirlTestBase {

    CureMarch march = Cure.march;

    @Test
    void 基本情報(){
        assertEquals("cure_march", march.girlName());
        assertEquals("緑川なお", march.humanName());
        assertEquals("緑川なお", march.fullName());
        assertEquals("Undefined.", march.humanFullName());
        assertEquals("キュアマーチ", march.precureName());
        assertEquals("井上麻里奈", march.castName());
        assertEquals(LocalDate.of(2012, 2, 26), march.createdDate());
        assertEquals(PrecureColor.GREEN, march.color());
        assertFalse(march.hasBirthday());
        assertEquals("(レディ？)\n" +
                "プリキュア・スマイルチャージ！\n" +
                "(ゴー！ゴー！レッツ・ゴー！マーチ！！)\n" +
                "勇気リンリン直球勝負！ キュアマーチ！\n" +
                "5つの光が導く未来！\n" +
                "輝け！スマイルプリキュア！",
                march.getTransformMessage());
        assertEquals(List.of("プリンセスマーチ", "ウルトラマーチ"), march.getExtraNames());
        assertEquals(3, march.getAttackMessages().size());
        assertEquals("プリキュア！マーチシュート！！",
                march.getAttackMessages().get(0));
        assertEquals("開け、ロイヤルクロック！\n" +
                "(みんなの力を1つにするクル！)\n" +
                "届け、希望の光！\n" +
                "はばたけ！光り輝く未来へ！\n" +
                "プリキュア！ロイヤルレインボーバースト！",
                march.getAttackMessages().get(1));
        assertEquals("(みんなの力を1つにするクル！)\n" +
                "プリキュア！ミラクルレインボーバースト！\n" +
                "輝けー！！\n" +
                "スマイルプリキュア！！",
                march.getAttackMessages().get(2));
        assertEquals(List.of("smile_charge"),
                            march.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(march, Girl.byName("march"));
    }

    @Test
    void 変身(){
        march.humanize();

        assertEquals("緑川なお", march.name());
        march.transform();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！マーチ！！)",
                "勇気リンリン直球勝負！ キュアマーチ！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアマーチ", march.name());

        messageTester.messages.clear();
        march.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリンセスマーチ", march.name());

        messageTester.messages.clear();
        march.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ウルトラマーチ", march.name());

        messageTester.messages.clear();
        march.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("緑川なお", march.name());

        messageTester.messages.clear();
        march.smileCharge();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！マーチ！！)",
                "勇気リンリン直球勝負！ キュアマーチ！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアマーチ", march.name());

        messageTester.messages.clear();
        march.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("緑川なお", march.name());
    }

    @Test
    void 攻撃(){
        march.humanize();
        assertThrows(RequireTransformException.class, () -> march.attack(), "Require transform.");

        march.transform();
        messageTester.messages.clear();
        march.attack();
        assertEquals(List.of("プリキュア！マーチシュート！！"),
                messageTester.messages);

        march.transform();
        messageTester.messages.clear();
        march.attack();
        assertEquals(List.of("開け、ロイヤルクロック！",
                "(みんなの力を1つにするクル！)",
                "届け、希望の光！",
                "はばたけ！光り輝く未来へ！",
                "プリキュア！ロイヤルレインボーバースト！"),
                messageTester.messages);

        march.transform();
        messageTester.messages.clear();
        march.attack();
        assertEquals(List.of("(みんなの力を1つにするクル！)",
                "プリキュア！ミラクルレインボーバースト！",
                "輝けー！！",
                "スマイルプリキュア！！"),
                messageTester.messages);
    }
}
