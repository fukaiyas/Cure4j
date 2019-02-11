package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureHeartTest extends GirlTestBase {

    CureHeart heart = Cure.heart;

    @Test
    void 基本情報(){
        assertEquals("cure_heart", heart.girlName());
        assertEquals("相田マナ", heart.humanName());
        assertEquals("相田マナ", heart.fullName());
        assertEquals("Undefined.", heart.humanFullName());
        assertEquals("キュアハート", heart.precureName());
        assertEquals("生天目仁美", heart.castName());
        assertEquals(LocalDate.of(2013, 2, 3), heart.createdDate());
        assertEquals(PrecureColor.PINK, heart.color());
        assertEquals("8/4", heart.birthday());
        assertEquals("プリキュアラブリンク！\n" +
                "L! O! V! E!\n" +
                "みなぎる愛！ キュアハート！\n" +
                "響け愛の鼓動！ドキドキプリキュア！\n" +
                "愛を無くした悲しいジコチューさん、\n" +
                "このキュアハートがあなたのドキドキ取り戻してみせる！",
                heart.getTransformMessage());
        assertEquals(List.of("キュアハート・パルテノンモード"), heart.getExtraNames());
        assertEquals(1, heart.getAttackMessages().size());
        assertEquals("あなたに届け！マイスイートハート！",
                heart.getAttackMessages().get(0));
        assertEquals(List.of("love_link"),
                            heart.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(heart, Girl.byName("heart"));
    }

    @Test
    void 変身(){
        heart.humanize();

        assertEquals("相田マナ", heart.name());
        heart.transform();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "みなぎる愛！ キュアハート！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "愛を無くした悲しいジコチューさん、",
                "このキュアハートがあなたのドキドキ取り戻してみせる！"),
                messageTester.messages);
        assertEquals("キュアハート", heart.name());

        messageTester.messages.clear();
        heart.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアハート・パルテノンモード", heart.name());

        messageTester.messages.clear();
        heart.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("相田マナ", heart.name());

        messageTester.messages.clear();
        heart.loveLink();
        assertEquals(List.of("プリキュアラブリンク！",
                "L! O! V! E!",
                "みなぎる愛！ キュアハート！",
                "響け愛の鼓動！ドキドキプリキュア！",
                "愛を無くした悲しいジコチューさん、",
                "このキュアハートがあなたのドキドキ取り戻してみせる！"),
                messageTester.messages);
        assertEquals("キュアハート", heart.name());

        messageTester.messages.clear();
        heart.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("相田マナ", heart.name());
    }

    @Test
    void 攻撃(){
        heart.humanize();
        assertThrows(RequireTransformException.class, () -> heart.attack(), "Require transform.");

        heart.transform();
        assertEquals("キュアハート", heart.name());
        messageTester.messages.clear();
        heart.attack();
        assertEquals(List.of("あなたに届け！マイスイートハート！"),
                messageTester.messages);

        heart.transform();
        assertEquals("キュアハート・パルテノンモード", heart.name());
        messageTester.messages.clear();
        heart.attack();
        assertEquals(List.of("あなたに届け！マイスイートハート！"),
                messageTester.messages);
    }
}
