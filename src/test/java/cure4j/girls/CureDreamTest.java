package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.*;
import static org.junit.jupiter.api.Assertions.*;

public class CureDreamTest extends GirlTestBase {

    CureDream dream = Cure.dream;

    @Test
    void 基本情報(){
        assertEquals("cure_dream", dream.girlName());
        assertEquals("夢原のぞみ", dream.humanName());
        assertEquals("夢原のぞみ", dream.fullName());
        assertEquals("Undefined.", dream.humanFullName());
        assertEquals("キュアドリーム", dream.precureName());
        assertEquals("三瓶由布子", dream.castName());
        assertEquals(LocalDate.of(2007, 2, 4), dream.createdDate());
        assertEquals(PrecureColor.PINK, dream.color());
        assertFalse(dream.hasBirthday());
        assertEquals("プリキュア！メタモルフォーゼ！\n" +
                        "大いなる希望の力、キュアドリーム！\n" +
                        "希望の力と未来の光！\n" +
                        "華麗に羽ばたく5つの心！\n" +
                        "Yes！プリキュア5！",
                        dream.getTransformMessage());
        assertEquals(0, dream.getExtraNames().size());
        assertEquals(1, dream.getAttackMessages().size());
        assertEquals("夢見る乙女の底力、受けてみなさい！\n" +
                        "プリキュア！シューティング・スター！",
                dream.getAttackMessages().get(0));
        assertEquals(List.of("metamorphose"), dream.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(dream, Girl.byName("dream"));
    }

    @Test
    void 変身() {
        dream.humanize();

        assertEquals("夢原のぞみ", dream.name());
        dream.transform();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "大いなる希望の力、キュアドリーム！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアドリーム", dream.name());

        messageTester.messages.clear();
        dream.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夢原のぞみ", dream.name());

        messageTester.messages.clear();
        dream.metamorphose();
        assertEquals(List.of("プリキュア！メタモルフォーゼ！",
                        "大いなる希望の力、キュアドリーム！",
                        "希望の力と未来の光！",
                        "華麗に羽ばたく5つの心！",
                        "Yes！プリキュア5！"),
                messageTester.messages);
        assertEquals("キュアドリーム", dream.name());

        messageTester.messages.clear();
        dream.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("夢原のぞみ", dream.name());
    }

    @Test
    void 攻撃(){
        dream.humanize();
        assertThrows(RequireTransformException.class, () -> dream.attack(), "Require transform.");

        dream.transform();
        messageTester.messages.clear();
        dream.attack();
        assertEquals(List.of("夢見る乙女の底力、受けてみなさい！",
                        "プリキュア！シューティング・スター！"),
                messageTester.messages);
    }
}
