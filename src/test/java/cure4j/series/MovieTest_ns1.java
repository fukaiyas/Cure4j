package cure4j.series;

import cure4j.Cure4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTest_ns1 {

    Movie ns1 = Movie.ns1;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズNewStage みらいのともだち", ns1.title);
        assertEquals(LocalDate.of(2012, 3, 17), ns1.startedDate);
        assertEquals(1, ns1.extraGirls.size());
        assertTrue(ns1.extraGirls.contains(Cure4j.Cure.echo));
    }

    @Test
    void エイリアス(){
        assertEquals(ns1, Movie.find("ns"));
        assertEquals(ns1, Movie.find("new_stage"));
        assertEquals(ns1, Movie.find("new_stage1"));
    }
}
