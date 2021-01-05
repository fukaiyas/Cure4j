package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_miracle_leap {

    Movie miracleLeap = Movie.miracleLeap;

    @Test
    void 各種プロパティ(){
        assertEquals("映画プリキュアミラクルリープ", miracleLeap.title);
        assertEquals(LocalDate.of(2020, 10, 31), miracleLeap.startedDate);
        assertEquals(0, miracleLeap.extraGirls.size());
    }

    @Test
    void エイリアス(){
        //定義なし
    }
}
