package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_dx2 {

    Movie dx2 = Movie.dx2;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズDX2 希望の光☆レインボージュエルを守れ!", dx2.title);
        assertEquals(LocalDate.of(2010, 3, 20), dx2.startedDate);
        assertEquals(0, dx2.extraGirls.size());
    }
}
