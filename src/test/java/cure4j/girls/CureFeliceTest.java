package cure4j.girls;

import cure4j.util.LinkleStoneFelice;
import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CureFeliceTest extends GirlTestBase {

    CureFelice felice = Cure.felice;

    @Test
    void 基本情報(){
        assertEquals("花海ことは", felice.humanName());
        assertEquals("花海ことは", felice.fullName());
        assertEquals("Undefined.", felice.humanFullName());
        assertEquals("早見沙織", felice.castName());
        assertFalse(felice.hasBirthday());
        assertEquals(0, felice.getExtraNames().size());
        assertEquals(1, felice.getAttackMessages().size());
        assertEquals("フラワーエコーワンド！\n" +
                "エメラルド！\n" +
                "キュアー・アップ！\n" +
                "プリキュア！エメラルド・リンカネーション！",
                felice.getAttackMessages().get(0));
        assertEquals(List.of("cure_up_rapapa"),
                            felice.getTransformCalls());
    }

    @Test
    void 基本情報_変身前(){
        felice.humanize();
        assertEquals("cure_felice", felice.girlName());
        assertEquals("キュアフェリーチェ", felice.precureName());
        assertEquals(PrecureColor.GREEN, felice.color());
        assertEquals(LocalDate.of(2016, 7, 3), felice.createdDate());
        assertEquals("", felice.getTransformMessage());
    }

    @Test
    void 基本情報_エメラルド(){
        felice.transform(LinkleStoneFelice.EMERALD);
        assertEquals("cure_felice_emerald", felice.girlName());
        assertEquals("キュアフェリーチェ", felice.precureName());
        assertEquals(PrecureColor.GREEN, felice.color());
        assertEquals(LocalDate.of(2016, 7, 3), felice.createdDate());
        assertEquals("キュアップ・ラパパ！エメラルド！\n" +
                "フェリーチェ・ファンファン・フラワーレ！\n" +
                "あまねく生命に祝福を！キュアフェリーチェ！",
                felice.getTransformMessage());
    }

    @Test
    void エイリアス(){
        assertEquals(felice, Girl.byName("felice"));
    }

    @Test
    void 変身(){
        felice.humanize();

        assertEquals("花海ことは", felice.name());
        felice.cureUpRapapa(LinkleStoneFelice.EMERALD);
        assertEquals(List.of("キュアップ・ラパパ！エメラルド！",
                "フェリーチェ・ファンファン・フラワーレ！",
                "あまねく生命に祝福を！キュアフェリーチェ！"),
                messageTester.messages);
        assertEquals("キュアフェリーチェ", felice.name());

        messageTester.messages.clear();
        felice.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("花海ことは", felice.name());
    }

    @Test
    void 攻撃(){
        felice.humanize();
        assertThrows(RequireTransformException.class, () -> felice.attack(), "Require transform.");

        felice.transform(LinkleStoneFelice.EMERALD);
        messageTester.messages.clear();
        felice.attack();
        assertEquals(List.of("フラワーエコーワンド！",
                "エメラルド！",
                "キュアー・アップ！",
                "プリキュア！エメラルド・リンカネーション！"),
                messageTester.messages);
    }
}
