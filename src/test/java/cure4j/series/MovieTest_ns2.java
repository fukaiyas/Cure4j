package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_ns2 {

    Movie ns2 = Movie.ns2;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズNewStage2 こころのともだち", ns2.title);
        assertEquals(LocalDate.of(2013, 3, 16), ns2.startedDate);
        assertEquals(0, ns2.extraGirls.size());
    }

    @Test
    void エイリアス(){
        assertEquals(ns2, Movie.find("new_stage2"));
    }
}
