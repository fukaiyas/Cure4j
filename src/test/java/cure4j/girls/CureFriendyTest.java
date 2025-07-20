package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureFriendyTest extends GirlTestBase {

    CureFriendy friendy = Cure.friendy;

    @Test
    void 基本情報(){
        assertEquals("cure_friendy", friendy.girlName());
        assertEquals("犬飼いろは", friendy.humanName());
        assertEquals("犬飼いろは", friendy.fullName());
        assertEquals("Undefined.", friendy.humanFullName());
        assertEquals("キュアフレンディ", friendy.precureName());
        assertEquals("種崎敦美", friendy.castName());
        assertEquals(LocalDate.of(2024, 2, 11), friendy.createdDate());
        assertEquals(PrecureColor.PURPLE, friendy.color());
        assertEquals("8/7", friendy.birthday());
        assertEquals("ワンダフルパクト！\n" +
                "プリキュア！マイエボリューション！\n" +
                "スリー！\n" +
                "ツー！\n" +
                "ワン！\n" +
                "みんなの笑顔で彩る世界！\n" +
                "キュアフレンディ！\n" +
                "あなたの声をきかせて\n" +
                "せーの！\n" +
                "わんだふるぷりきゅあ！",
                friendy.getTransformMessage());
        assertEquals(0, friendy.getExtraNames().size());
        assertEquals(1, friendy.getAttackMessages().size());
        assertEquals("フレンドリータクト！\n" +
                "ワンダフルをきみに！\n" +
                "ワン！ワン！わ〜ん！\n" +
                "ガルガルな心、飛んでけー！！\n" +
                "プリキュア！フレンドリベラーレ！",
                friendy.getAttackMessages().get(0));
        assertEquals(List.of("my_evolution"), friendy.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(friendy, Girl.byName("friendy"));
    }

    @Test
    void 変身() {
        friendy.humanize();

        assertEquals("犬飼いろは", friendy.name());
        friendy.transform();
        assertEquals(List.of("ワンダフルパクト！",
                "プリキュア！マイエボリューション！",
                "スリー！",
                "ツー！",
                "ワン！",
                "みんなの笑顔で彩る世界！",
                "キュアフレンディ！",
                "あなたの声をきかせて",
                "せーの！",
                "わんだふるぷりきゅあ！"),
                messageTester.messages);
        assertEquals("キュアフレンディ", friendy.name());

        messageTester.messages.clear();
        friendy.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("犬飼いろは", friendy.name());

        messageTester.messages.clear();
        friendy.myEvolution();
        assertEquals(List.of("ワンダフルパクト！",
                "プリキュア！マイエボリューション！",
                "スリー！",
                "ツー！",
                "ワン！",
                "みんなの笑顔で彩る世界！",
                "キュアフレンディ！",
                "あなたの声をきかせて",
                "せーの！",
                "わんだふるぷりきゅあ！"),
                messageTester.messages);
        assertEquals("キュアフレンディ", friendy.name());

        messageTester.messages.clear();
        friendy.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("犬飼いろは", friendy.name());
    }

    @Test
    void 攻撃(){
        friendy.humanize();
        assertThrows(RequireTransformException.class, () -> friendy.attack(), "Require transform.");

        friendy.transform();
        messageTester.messages.clear();
        friendy.attack();
        assertEquals(List.of("フレンドリータクト！",
                "ワンダフルをきみに！",
                "ワン！ワン！わ〜ん！",
                "ガルガルな心、飛んでけー！！",
                "プリキュア！フレンドリベラーレ！"),
                messageTester.messages);
    }
}