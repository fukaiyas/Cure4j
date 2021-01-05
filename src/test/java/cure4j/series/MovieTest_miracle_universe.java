package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_miracle_universe {

    Movie miracleUniverse = Movie.miracleUniverse;

    @Test
    void 各種プロパティ(){
        assertEquals("映画プリキュアミラクルユニバース", miracleUniverse.title);
        assertEquals(LocalDate.of(2019, 3, 16), miracleUniverse.startedDate);
        assertEquals(0, miracleUniverse.extraGirls.size());
    }

    @Test
    void エイリアス(){
        //定義なし
    }
}
