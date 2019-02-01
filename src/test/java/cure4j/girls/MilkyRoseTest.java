package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Milky;
import static org.junit.jupiter.api.Assertions.*;

public class MilkyRoseTest extends GirlTestBase {

    MilkyRose rose = Milky.rose;

    @Test
    void 基本情報(){
        assertEquals("milky_rose", rose.girlName());
        assertEquals("美々野くるみ", rose.humanName());
        assertEquals("美々野くるみ", rose.fullName());
        assertEquals("Undefined.", rose.humanFullName());
        assertEquals("ミルキィローズ", rose.precureName());
        assertEquals("仙台エリ", rose.castName());
        assertEquals(LocalDate.of(2008, 4, 6), rose.createdDate());
        assertEquals(PrecureColor.PURPLE, rose.color());
        assertFalse(rose.hasBirthday());
        assertEquals("スカイローズ・トランスレイト！\n" +
                        "青いバラは秘密のしるし！ ミルキィローズ！",
                        rose.getTransformMessage());
        assertEquals(0, rose.getExtraNames().size());
        assertEquals(1, rose.getAttackMessages().size());
        assertEquals("邪悪な力を包み込む\n" +
                        "バラの吹雪を咲かせましょう！\n" +
                        "ミルキィローズ・ブリザード！",
                rose.getAttackMessages().get(0));
        assertEquals(List.of("sky_rose_translate", "translate"),
                rose.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(rose, Girl.byName("rose"));
    }

    @Test
    void 変身() {
        rose.humanize();

        assertEquals("美々野くるみ", rose.name());
        rose.transform();
        assertEquals(List.of("スカイローズ・トランスレイト！",
                        "青いバラは秘密のしるし！ ミルキィローズ！"),
                messageTester.messages);
        assertEquals("ミルキィローズ", rose.name());

        messageTester.messages.clear();
        rose.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美々野くるみ", rose.name());

        messageTester.messages.clear();
        rose.skyRoseTranslate();
        assertEquals(List.of("スカイローズ・トランスレイト！",
                        "青いバラは秘密のしるし！ ミルキィローズ！"),
                messageTester.messages);
        assertEquals("ミルキィローズ", rose.name());

        messageTester.messages.clear();
        rose.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("美々野くるみ", rose.name());
    }

    @Test
    void 攻撃(){
        rose.humanize();
        assertThrows(RequireTransformException.class, () -> rose.attack(), "Require transform.");

        rose.transform();
        messageTester.messages.clear();
        rose.attack();
        assertEquals(List.of("邪悪な力を包み込む",
                        "バラの吹雪を咲かせましょう！",
                        "ミルキィローズ・ブリザード！"),
                messageTester.messages);
    }
}
