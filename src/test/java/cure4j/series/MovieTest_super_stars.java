package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_super_stars {

    Movie superStars = Movie.superStars;

    @Test
    void 各種プロパティ(){
        assertEquals("映画プリキュアスーパースターズ！", superStars.title);
        assertEquals(LocalDate.of(2018, 3, 17), superStars.startedDate);
        assertEquals(0, superStars.extraGirls.size());
    }

    @Test
    void エイリアス(){
        assertEquals(superStars, Movie.find("ss"));
    }
}
