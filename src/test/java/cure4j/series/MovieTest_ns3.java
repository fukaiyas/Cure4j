package cure4j.series;

import cure4j.Cure4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTest_ns3 {

    Movie ns3 = Movie.ns3;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズ NewStage3 永遠のともだち", ns3.title);
        assertEquals(LocalDate.of(2014, 3, 15), ns3.startedDate);
        assertEquals(1, ns3.extraGirls.size());
        assertTrue(ns3.extraGirls.contains(Cure4j.Cure.echo));
    }

    @Test
    void エイリアス(){
        assertEquals(ns3, Movie.find("new_stage3"));
    }
}
