package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_dream_stars {

    Movie dreamStars = Movie.dreamStars;

    @Test
    void 各種プロパティ(){
        assertEquals("映画プリキュアドリームスターズ！", dreamStars.title);
        assertEquals(LocalDate.of(2017, 3, 18), dreamStars.startedDate);
        assertEquals(0, dreamStars.extraGirls.size());
    }

    @Test
    void エイリアス(){
        //TODO "ds"ではなく？
        assertEquals(dreamStars, Movie.find("dc"));
    }
}
