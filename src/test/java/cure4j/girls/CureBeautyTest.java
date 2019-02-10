package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureBeautyTest extends GirlTestBase {

    CureBeauty beauty = Cure.beauty;

    @Test
    void 基本情報(){
        assertEquals("cure_beauty", beauty.girlName());
        assertEquals("青木れいか", beauty.humanName());
        assertEquals("青木れいか", beauty.fullName());
        assertEquals("Undefined.", beauty.humanFullName());
        assertEquals("キュアビューティ", beauty.precureName());
        assertEquals("西村ちなみ", beauty.castName());
        assertEquals(LocalDate.of(2012, 3, 4), beauty.createdDate());
        assertEquals(PrecureColor.BLUE, beauty.color());
        assertFalse(beauty.hasBirthday());
        assertEquals("(レディ？)\n" +
                "プリキュア・スマイルチャージ！\n" +
                "(ゴー！ゴー！レッツ・ゴー！ビューティ！！)\n" +
                "しんしんと降り積もる清き心！ キュアビューティ！\n" +
                "5つの光が導く未来！\n" +
                "輝け！スマイルプリキュア！",
                beauty.getTransformMessage());
        assertEquals(List.of("プリンセスビューティ", "ウルトラビューティ"), beauty.getExtraNames());
        assertEquals(3, beauty.getAttackMessages().size());
        assertEquals("プリキュア！ビューティブリザード！！",
                beauty.getAttackMessages().get(0));
        assertEquals("開け、ロイヤルクロック！\n" +
                "(みんなの力を1つにするクル！)\n" +
                "届け、希望の光！\n" +
                "はばたけ！光り輝く未来へ！\n" +
                "プリキュア！ロイヤルレインボーバースト！",
                beauty.getAttackMessages().get(1));
        assertEquals("(みんなの力を1つにするクル！)\n" +
                "プリキュア！ミラクルレインボーバースト！\n" +
                "輝けー！！\n" +
                "スマイルプリキュア！！",
                beauty.getAttackMessages().get(2));
        assertEquals(List.of("smile_charge"),
                            beauty.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(beauty, Girl.byName("beauty"));
    }

    @Test
    void 変身(){
        beauty.humanize();

        assertEquals("青木れいか", beauty.name());
        beauty.transform();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！ビューティ！！)",
                "しんしんと降り積もる清き心！ キュアビューティ！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアビューティ", beauty.name());

        messageTester.messages.clear();
        beauty.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("プリンセスビューティ", beauty.name());

        messageTester.messages.clear();
        beauty.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("ウルトラビューティ", beauty.name());

        messageTester.messages.clear();
        beauty.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("青木れいか", beauty.name());

        messageTester.messages.clear();
        beauty.smileCharge();
        assertEquals(List.of("(レディ？)",
                "プリキュア・スマイルチャージ！",
                "(ゴー！ゴー！レッツ・ゴー！ビューティ！！)",
                "しんしんと降り積もる清き心！ キュアビューティ！",
                "5つの光が導く未来！",
                "輝け！スマイルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアビューティ", beauty.name());

        messageTester.messages.clear();
        beauty.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("青木れいか", beauty.name());
    }

    @Test
    void 攻撃(){
        beauty.humanize();
        assertThrows(RequireTransformException.class, () -> beauty.attack(), "Require transform.");

        beauty.transform();
        messageTester.messages.clear();
        beauty.attack();
        assertEquals(List.of("プリキュア！ビューティブリザード！！"),
                messageTester.messages);

        beauty.transform();
        messageTester.messages.clear();
        beauty.attack();
        assertEquals(List.of("開け、ロイヤルクロック！",
                "(みんなの力を1つにするクル！)",
                "届け、希望の光！",
                "はばたけ！光り輝く未来へ！",
                "プリキュア！ロイヤルレインボーバースト！"),
                messageTester.messages);

        beauty.transform();
        messageTester.messages.clear();
        beauty.attack();
        assertEquals(List.of("(みんなの力を1つにするクル！)",
                "プリキュア！ミラクルレインボーバースト！",
                "輝けー！！",
                "スマイルプリキュア！！"),
                messageTester.messages);
    }
}
