package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureWhipTest extends GirlTestBase {

    CureWhip whip = Cure.whip;

    @Test
    void 基本情報(){
        assertEquals("cure_whip", whip.girlName());
        assertEquals("宇佐美いちか", whip.humanName());
        assertEquals("宇佐美いちか", whip.fullName());
        assertEquals("Undefined.", whip.humanFullName());
        assertEquals("キュアホイップ", whip.precureName());
        assertEquals("美山加恋", whip.castName());
        assertEquals(LocalDate.of(2017, 2, 5), whip.createdDate());
        assertEquals(PrecureColor.PINK, whip.color());
        assertEquals("1/7", whip.birthday());
        assertEquals("キュアラモード・デコレーション！\n" +
                "ショートケーキ！\n" +
                "元気と笑顔を！\n" +
                "レッツ・ラ・まぜまぜ！\n" +
                "キュアホイップ！できあがり！\n" +
                "キラキラ☆プリキュアアラモード！",
                whip.getTransformMessage());
        assertEquals(0, whip.getExtraNames().size());
        assertEquals(1, whip.getAttackMessages().size());
        assertEquals("キラキラキラルン！ホイップ・デコレーション！",
                whip.getAttackMessages().get(0));
        assertEquals(List.of("cure_la_mode_decoration"), whip.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(whip, Girl.byName("whip"));
    }

    @Test
    void 変身() {
        whip.humanize();

        assertEquals("宇佐美いちか", whip.name());
        whip.transform();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "ショートケーキ！",
                "元気と笑顔を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアホイップ！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアホイップ", whip.name());

        messageTester.messages.clear();
        whip.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("宇佐美いちか", whip.name());

        messageTester.messages.clear();
        whip.cureLaModeDecoration();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "ショートケーキ！",
                "元気と笑顔を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアホイップ！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアホイップ", whip.name());

        messageTester.messages.clear();
        whip.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("宇佐美いちか", whip.name());
    }

    @Test
    void 攻撃(){
        whip.humanize();
        assertThrows(RequireTransformException.class, () -> whip.attack(), "Require transform.");

        whip.transform();
        messageTester.messages.clear();
        whip.attack();
        assertEquals(List.of("キラキラキラルン！ホイップ・デコレーション！"),
                messageTester.messages);
    }
}
