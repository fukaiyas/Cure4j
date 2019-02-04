package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureBerryTest extends GirlTestBase {

    CureBerry berry = Cure.berry;

    @Test
    void 基本情報(){
        assertEquals("cure_berry", berry.girlName());
        assertEquals("蒼乃美希", berry.humanName());
        assertEquals("蒼乃美希", berry.fullName());
        assertEquals("Undefined.", berry.humanFullName());
        assertEquals("キュアベリー", berry.precureName());
        assertEquals("喜多村英梨", berry.castName());
        assertEquals(LocalDate.of(2009, 2, 8), berry.createdDate());
        assertEquals(PrecureColor.BLUE, berry.color());
        assertFalse(berry.hasBirthday());
        assertEquals("チェインジ！プリキュア・ビートアップ！\n" +
                        "ブルーのハートは希望のしるし！\n" +
                        "つみたてフレッシュ、キュアベリー！\n" +
                        "レッツプリキュア！",
                        berry.getTransformMessage());
        assertEquals(List.of("キュアエンジェルベリー"), berry.getExtraNames());
        assertEquals(1, berry.getAttackMessages().size());
        assertEquals("悪いの悪いの飛んでいけ！\n" +
                        "プリキュア！エスポワールシャワーフレッシュ！",
                berry.getAttackMessages().get(0));
        assertEquals(List.of("change_precure_beat_up",
                "change",
                "beat_up"),
                berry.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(berry, Girl.byName("berry"));
    }

    @Test
    void 変身() {
        berry.humanize();

        assertEquals("蒼乃美希", berry.name());
        berry.transform();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ブルーのハートは希望のしるし！",
                        "つみたてフレッシュ、キュアベリー！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアベリー", berry.name());

        messageTester.messages.clear();
        berry.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアエンジェルベリー", berry.name());

        messageTester.messages.clear();
        berry.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("蒼乃美希", berry.name());

        messageTester.messages.clear();
        berry.changePrecureBeatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ブルーのハートは希望のしるし！",
                        "つみたてフレッシュ、キュアベリー！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアベリー", berry.name());

        messageTester.messages.clear();
        berry.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("蒼乃美希", berry.name());

        messageTester.messages.clear();
        berry.change();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ブルーのハートは希望のしるし！",
                        "つみたてフレッシュ、キュアベリー！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアベリー", berry.name());

        messageTester.messages.clear();
        berry.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("蒼乃美希", berry.name());

        messageTester.messages.clear();
        berry.beatUp();
        assertEquals(List.of("チェインジ！プリキュア・ビートアップ！",
                        "ブルーのハートは希望のしるし！",
                        "つみたてフレッシュ、キュアベリー！",
                        "レッツプリキュア！"),
                messageTester.messages);
        assertEquals("キュアベリー", berry.name());

        messageTester.messages.clear();
        berry.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("蒼乃美希", berry.name());
    }

    @Test
    void 攻撃(){
        berry.humanize();
        assertThrows(RequireTransformException.class, () -> berry.attack(), "Require transform.");

        berry.transform();
        assertEquals("キュアベリー", berry.name());
        messageTester.messages.clear();
        berry.attack();
        assertEquals(List.of("悪いの悪いの飛んでいけ！",
                        "プリキュア！エスポワールシャワーフレッシュ！"),
                messageTester.messages);

        berry.transform();
        assertEquals("キュアエンジェルベリー", berry.name());
        messageTester.messages.clear();
        berry.attack();
        assertEquals(List.of("悪いの悪いの飛んでいけ！",
                        "プリキュア！エスポワールシャワーフレッシュ！"),
                messageTester.messages);
    }
}
