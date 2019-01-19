package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_memories {

    Movie memories = Movie.memories;

    @Test
    void 各種プロパティ(){
        assertEquals("映画ＨＵＧっと！プリキュア♡ふたりはプリキュア オールスターズメモリーズ", memories.title);
        assertEquals(LocalDate.of(2018, 10, 27), memories.startedDate);
        assertEquals(0, memories.extraGirls.size());
    }

    @Test
    void エイリアス(){
        //TODO "all_stars_memories"とか？
    }
}
