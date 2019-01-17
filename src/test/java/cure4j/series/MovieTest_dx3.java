package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_dx3 {

    Movie dx3 = Movie.dx3;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズDX3 未来にとどけ! 世界をつなぐ☆虹色の花", dx3.title);
        assertEquals(LocalDate.of(2011, 3, 19), dx3.startedDate);
        assertEquals(0, dx3.extraGirls.size());
    }
}
