package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;
import test.util.TestUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.*;

public class CurePrincessTest extends GirlTestBase {

    CurePrincess princess = Cure.princess;

    @Test
    void 基本情報(){
        assertEquals("cure_princess", princess.girlName());
        assertEquals("白雪ひめ", princess.humanName());
        assertEquals("ヒメルダ・ウインドウ・キュアクイーン・オブ・ザ・ブルースカイ", princess.fullName());
        assertEquals("ヒメルダ・ウインドウ・キュアクイーン・オブ・ザ・ブルースカイ", princess.humanFullName());
        assertEquals("キュアプリンセス", princess.precureName());
        assertEquals("潘めぐみ", princess.castName());
        assertEquals(LocalDate.of(2014, 2, 2), princess.createdDate());
        assertEquals(PrecureColor.BLUE, princess.color());
        assertFalse(princess.hasBirthday());
        assertEquals("(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！\n" +
                "天空に舞う蒼き風！キュアプリンセス！\n" +
                "ハピネス注入！幸せチャージ！\n" +
                "ハピネスチャージプリキュア！",
                princess.getTransformMessage());
        assertEquals(List.of("キュアプリンセス シャーベットバレエ",
                        "キュアプリンセス マカダミアフラダンス"),
                        princess.getExtraNames());
        assertEquals(3, princess.getAttackMessages().size());
        assertEquals(TestUtil.waveDash2FullwidthTilde(
                "勇気の光を聖なる力へ！\n" +
                "ラブプリブレス！\n" +
                "プリキュア！ブルーハッピーシュート！！\n" +
                "勇気よ、天に帰れ！\n" +
                "(ゴクラ〜ク…)"),
                princess.getAttackMessages().get(0));
        assertEquals("(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！シャーベットバレエ！！\n" +
                "プリキュア！アラベスクシャワー！！",
                princess.getAttackMessages().get(1));
        assertEquals("(かわルンルン！)\n" +
                "プリキュアくるりんミラーチェンジ！マカダミアフラダンス！！\n" +
                "プリキュア！ハワイアンアロハロエ！！",
                princess.getAttackMessages().get(2));
        assertEquals(List.of("kururin_mirror_change"),
                            princess.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(princess, Girl.byName("princess"));
    }

    @Test
    void 変身(){
        princess.humanize();

        assertEquals("白雪ひめ", princess.name());
        princess.transform();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！",
                "天空に舞う蒼き風！キュアプリンセス！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアプリンセス", princess.name());

        messageTester.messages.clear();
        princess.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアプリンセス シャーベットバレエ", princess.name());

        messageTester.messages.clear();
        princess.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キュアプリンセス マカダミアフラダンス", princess.name());

        messageTester.messages.clear();
        princess.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("白雪ひめ", princess.name());

        messageTester.messages.clear();
        princess.kururinMirrorChange();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！",
                "天空に舞う蒼き風！キュアプリンセス！",
                "ハピネス注入！幸せチャージ！",
                "ハピネスチャージプリキュア！"),
                messageTester.messages);
        assertEquals("キュアプリンセス", princess.name());

        messageTester.messages.clear();
        princess.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("白雪ひめ", princess.name());
    }

    @Test
    void 攻撃(){
        princess.humanize();
        assertThrows(RequireTransformException.class, () -> princess.attack(), "Require transform.");

        princess.transform();
        messageTester.messages.clear();
        princess.attack();
        assertEquals(List.of("勇気の光を聖なる力へ！",
                "ラブプリブレス！",
                "プリキュア！ブルーハッピーシュート！！",
                "勇気よ、天に帰れ！",
                TestUtil.waveDash2FullwidthTilde("(ゴクラ〜ク…)")),
                messageTester.messages);

        princess.transform();
        messageTester.messages.clear();
        princess.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！シャーベットバレエ！！",
                "プリキュア！アラベスクシャワー！！"),
                messageTester.messages);

        princess.transform();
        messageTester.messages.clear();
        princess.attack();
        assertEquals(List.of("(かわルンルン！)",
                "プリキュアくるりんミラーチェンジ！マカダミアフラダンス！！",
                "プリキュア！ハワイアンアロハロエ！！"),
                messageTester.messages);
    }
}
