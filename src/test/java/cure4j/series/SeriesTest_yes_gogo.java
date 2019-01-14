package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_yes_gogo {

    Series yesGogo = Precure.yesGogo;

    @Test
    void 各種プロパティ(){
        assertEquals("yes_gogo", yesGogo.seriesName);
        assertEquals("Yes！ プリキュア5 Go Go！", yesGogo.title);
        assertEquals(LocalDate.of(2008, 2, 3), yesGogo.startedDate);
        assertEquals(LocalDate.of(2009, 1, 25), yesGogo.endedDate);
        assertEquals(6, yesGogo.girls.size());
        assertTrue(yesGogo.girls.contains(Cure.dream));
        assertTrue(yesGogo.girls.contains(Cure.rouge));
        assertTrue(yesGogo.girls.contains(Cure.lemonade));
        assertTrue(yesGogo.girls.contains(Cure.mint));
        assertTrue(yesGogo.girls.contains(Cure.aqua));
        assertTrue(yesGogo.girls.contains(Milky.rose));
    }

    @Test
    void エイリアス(){
        assertEquals(yesGogo, Precure.find("yes_precure_five_gogo"));
        assertEquals(yesGogo, Precure.find("yes_precure5_gogo"));
    }

    @Test
    void onAir(){
        assertFalse(yesGogo.isOnAir(LocalDate.of(2008, 2, 2)));
        assertTrue(yesGogo.isOnAir(LocalDate.of(2008, 2, 3)));
        assertTrue(yesGogo.isOnAir(LocalDate.of(2009, 1, 25)));
        assertFalse(yesGogo.isOnAir(LocalDate.of(2009, 1, 26)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(yesGogo.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2008, 7, 18));
        assertTrue(yesGogo.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
