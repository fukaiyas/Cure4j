package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureWinkTest extends GirlTestBase {

    CureWink wink = Cure.wink;

    @Test
    void 基本情報(){
        assertEquals("cure_wink", wink.girlName());
        assertEquals("蒼風なな", wink.humanName());
        assertEquals("蒼風なな", wink.fullName());
        assertEquals("Undefined.", wink.humanFullName());
        assertEquals("キュアウインク", wink.precureName());
        assertEquals("髙橋ミナミ", wink.castName());
        assertEquals(LocalDate.of(2025, 2, 16), wink.createdDate());
        assertEquals(PrecureColor.BLUE, wink.color());
        assertEquals("7/6", wink.birthday());
        assertEquals("""
                        プリキュア！ライトアップ！
                        キラキラドレスチェンジ！YEAH!
                        きみと～！ YEAH！
                        一緒にYEAH!
                        キミと瞬く、ハートの勇気！
                        お目目パッチン、キュアウインク！
                        ウィーアー！キミとアイドルプリキュア！""",
                wink.getTransformMessage());
        assertEquals(0, wink.getExtraNames().size());
        assertEquals(1, wink.getAttackMessages().size());
        assertEquals("""
                        クライマックスは私！
                        聞いて下さい
                        きらめきへ
                        踏み出そう
                        受け取った勇気つないで
                        まばたきの数だけ
                        五線譜に焼きつけていく
                        今日の優しい音
                        ずっと忘れないよ
                        出会えたキミへと
                        奏でたいいつまでも
                        鳴り止まないメロディー
                        プリキュアウインククレッシェンド！""",
                wink.getAttackMessages().get(0));
        assertEquals(List.of("light_up"), wink.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(wink, Girl.byName("wink"));
    }

    @Test
    void 変身(){
        wink.humanize();

        assertEquals("蒼風なな", wink.name());
        wink.transform();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラドレスチェンジ！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "キミと瞬く、ハートの勇気！",
                "お目目パッチン、キュアウインク！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアウインク", wink.name());

        messageTester.messages.clear();
        wink.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("蒼風なな", wink.name());

        messageTester.messages.clear();
        wink.lightUp();
        assertEquals(List.of("プリキュア！ライトアップ！",
                "キラキラドレスチェンジ！YEAH!",
                "きみと～！ YEAH！",
                "一緒にYEAH!",
                "キミと瞬く、ハートの勇気！",
                "お目目パッチン、キュアウインク！",
                "ウィーアー！キミとアイドルプリキュア！"),
                messageTester.messages);
        assertEquals("キュアウインク", wink.name());

        messageTester.messages.clear();
        wink.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("蒼風なな", wink.name());
    }

    @Test
    void 攻撃(){
        wink.humanize();
        assertThrows(RequireTransformException.class, () -> wink.attack(), "Require transform.");

        wink.transform();
        messageTester.messages.clear();
        wink.attack();
        assertEquals(List.of("クライマックスは私！",
                "聞いて下さい",
                "きらめきへ",
                "踏み出そう",
                "受け取った勇気つないで",
                "まばたきの数だけ",
                "五線譜に焼きつけていく",
                "今日の優しい音",
                "ずっと忘れないよ",
                "出会えたキミへと",
                "奏でたいいつまでも",
                "鳴り止まないメロディー",
                "プリキュアウインククレッシェンド！"),
                messageTester.messages);
    }
}
