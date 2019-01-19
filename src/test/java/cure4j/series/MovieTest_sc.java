package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_sc {

    Movie sc = Movie.sc;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズ 春のカーニバル", sc.title);
        assertEquals(LocalDate.of(2015, 3, 14), sc.startedDate);
        assertEquals(0, sc.extraGirls.size());
    }

    @Test
    void エイリアス(){
        assertEquals(sc, Movie.find("spring_carnival"));
    }
}
