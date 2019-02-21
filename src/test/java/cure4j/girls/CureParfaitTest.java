package cure4j.girls;

import cure4j.util.PrecureColor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cure4j.Cure4j.Cure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CureParfaitTest extends GirlTestBase {

    CureParfait parfait = Cure.parfait;

    @Test
    void 基本情報(){
        assertEquals("cure_parfait", parfait.girlName());
        assertEquals("キラ星シエル", parfait.humanName());
        assertEquals("キラ星シエル", parfait.fullName());
        assertEquals("Undefined.", parfait.humanFullName());
        assertEquals("キュアパルフェ", parfait.precureName());
        assertEquals("水瀬いのり", parfait.castName());
        assertEquals(LocalDate.of(2017, 7, 16), parfait.createdDate());
        assertEquals(PrecureColor.RAINBOW, parfait.color());
        assertEquals("7/30", parfait.birthday());
        assertEquals("キュアラモード・デコレーション！\n" +
                "パフェ！\n" +
                "夢と希望を！\n" +
                "レッツ・ラ・まぜまぜ！\n" +
                "キュアパルフェ！できあがり！\n" +
                "キラキラ☆プリキュアアラモード！",
                parfait.getTransformMessage());
        assertEquals(0, parfait.getExtraNames().size());
        assertEquals(1, parfait.getAttackMessages().size());
        assertEquals("アン！ドゥ！トレビアン！キラクルレインボー！\n" +
                "ボナペティ！",
                parfait.getAttackMessages().get(0));
        assertEquals(List.of("cure_la_mode_decoration"), parfait.getTransformCalls());
    }

    @Test
    void エイリアス(){
        assertEquals(parfait, Girl.byName("parfait"));
    }

    @Test
    void 変身() {
        parfait.humanize();

        assertEquals("キラ星シエル", parfait.name());
        parfait.transform();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "パフェ！",
                "夢と希望を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアパルフェ！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアパルフェ", parfait.name());

        messageTester.messages.clear();
        parfait.transform();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キラ星シエル", parfait.name());

        messageTester.messages.clear();
        parfait.cureLaModeDecoration();
        assertEquals(List.of("キュアラモード・デコレーション！",
                "パフェ！",
                "夢と希望を！",
                "レッツ・ラ・まぜまぜ！",
                "キュアパルフェ！できあがり！",
                "キラキラ☆プリキュアアラモード！"),
                messageTester.messages);
        assertEquals("キュアパルフェ", parfait.name());

        messageTester.messages.clear();
        parfait.humanize();
        assertEquals(Collections.emptyList(), messageTester.messages);
        assertEquals("キラ星シエル", parfait.name());
    }

    @Test
    void 攻撃(){
        parfait.humanize();
        assertThrows(RequireTransformException.class, () -> parfait.attack(), "Require transform.");

        parfait.transform();
        messageTester.messages.clear();
        parfait.attack();
        assertEquals(List.of("アン！ドゥ！トレビアン！キラクルレインボー！",
                "ボナペティ！"),
                messageTester.messages);
    }
}
