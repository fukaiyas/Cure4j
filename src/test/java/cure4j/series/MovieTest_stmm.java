package cure4j.series;

import cure4j.Cure4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTest_stmm {

    Movie stmm = Movie.stmm;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズ みんなで歌う 奇跡の魔法！", stmm.title);
        assertEquals(LocalDate.of(2016, 3, 19), stmm.startedDate);
        assertEquals(1, stmm.extraGirls.size());
        assertTrue(stmm.extraGirls.contains(Cure4j.Cure.echo));
    }

    @Test
    void エイリアス(){
        assertEquals(stmm, Movie.find("sing_together_miracle_magic"));
    }
}
