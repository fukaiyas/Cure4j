package cure4j.series;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest_dx1 {

    Movie dx1 = Movie.dx1;

    @Test
    void 各種プロパティ(){
        assertEquals("映画 プリキュアオールスターズDX みんなともだちっ☆奇跡の全員大集合!", dx1.title);
        assertEquals(LocalDate.of(2009, 3, 20), dx1.startedDate);
        assertEquals(0, dx1.extraGirls.size());
    }

    @Test
    void エイリアス(){
        assertEquals(dx1, Movie.find("dx"));
    }
}
