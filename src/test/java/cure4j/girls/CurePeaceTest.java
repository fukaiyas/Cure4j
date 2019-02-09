package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CurePeaceTest extends GirlTestBase {

    CurePeace peace = Cure.peace;

    @Test
    void 基本情報(){
        assertEquals("cure_peace", peace.girlName());
        assertEquals("黄瀬やよい", peace.humanName());
        assertEquals("黄瀬やよい", peace.fullName());
        assertEquals("Undefined.", peace.humanFullName());
        assertEquals("キュアピース", peace.precureName());
        assertEquals("金元寿子", peace.castName());
        assertEquals(LocalDate.of(2012, 2, 19), peace.createdDate());
        assertEquals(PrecureColor.YELLOW, peace.color());
        assertFalse(peace.hasBirthday());
        assertEquals("(レディ？)\n" +
                "プリキュア・スマイルチャージ！\n" +
                "(ゴー！ゴー！レッツ・ゴー！ピース！！)\n" +
                "ピカピカピカリンジャンケンポン！ キュアピース！\n" +
                "5つの光が導く未来！\n" +
                "輝け！スマイルプリキュア！",
                peace.getTransformMessage());
        assertEquals(List.of("プリンセスピース", "ウルトラピース"), peace.getExtraNames());
        assertEquals(3, peace.getAttackMessages().size());
        assertEquals("プリキュア！ピースサンダー！！",
                peace.getAttackMessages().get(0));
        assertEquals("開け、ロイヤルクロック！\n" +
                "(みんなの力を1つにするクル！)\n" +
                "届け、希望の光！\n" +
                "はばたけ！光り輝く未来へ！\n" +
                "プリキュア！ロイヤルレインボーバースト！",
                peace.getAttackMessages().get(1));
        assertEquals("(みんなの力を1つにするクル！)\n" +
                "プリキュア！ミラクルレインボーバースト！\n" +
                "輝けー！！\n" +
                "スマイルプリキュア！！",
                peace.getAttackMessages().get(2));
        assertEquals(List.of("smile_charge"),
                            peace.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(peace, Girl.byName("peace"));
    }

    @Test
    void 変身(){
        peace.humanize();

        assertEquals("黄瀬やよい", peace.name());
        peace.transform();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！ピース！！)",
                "ピカピカピカリンジャンケンポン！ キュアピース！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアピース", peace.name());

        messageTester.messages.clear();
        peace.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリンセスピース", peace.name());

        messageTester.messages.clear();
        peace.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ウルトラピース", peace.name());

        messageTester.messages.clear();
        peace.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("黄瀬やよい", peace.name());

        messageTester.messages.clear();
        peace.smileCharge();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！ピース！！)",
                "ピカピカピカリンジャンケンポン！ キュアピース！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアピース", peace.name());

        messageTester.messages.clear();
        peace.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("黄瀬やよい", peace.name());
    }

    @Test
    void 攻撃(){
        peace.humanize();
        assertThrows(RequireTransformException.class, () -> peace.attack(), "Require transform.");

        peace.transform();
        messageTester.messages.clear();
        peace.attack();
        assertEquals(List.of("プリキュア！ピースサンダー！！"),
                messageTester.messages);

        peace.transform();
        messageTester.messages.clear();
        peace.attack();
        assertEquals(List.of("開け、ロイヤルクロック！",
                "(みんなの力を1つにするクル！)",
                "届け、希望の光！",
                "はばたけ！光り輝く未来へ！",
                "プリキュア！ロイヤルレインボーバースト！"),
                messageTester.messages);

        peace.transform();
        messageTester.messages.clear();
        peace.attack();
        assertEquals(List.of("(みんなの力を1つにするクル！)",
                "プリキュア！ミラクルレインボーバースト！",
                "輝けー！！",
                "スマイルプリキュア！！"),
                messageTester.messages);
    }

    @Test
    void ピカリンジャンケン(){
        messageTester.messages.clear();
        peace.pikarinJanken();
        assertEquals(List.of("ピカピカピカリン",
                "ジャンケンポン！"),
                messageTester.messages.subList(0, 2));
        assertTrue(Set.of(
                "（グー）", "（チョキ）", "（パー）", "（グッチョッパー）").contains(
                        messageTester.messages.get(2)));
    }
}
