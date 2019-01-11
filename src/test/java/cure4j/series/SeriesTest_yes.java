package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_yes {

    @Test
    void 各種プロパティ(){
        var yes = Precure.yes;
        assertEquals("yes", yes.seriesName);
        assertEquals("Yes！ プリキュア5", yes.title);
        assertEquals(LocalDate.of(2007, 2, 4), yes.startedDate);
        assertEquals(LocalDate.of(2008, 1, 27), yes.endedDate);
        assertEquals(5, yes.girls.size());
        assertTrue(yes.girls.contains(Cure.dream));
        assertTrue(yes.girls.contains(Cure.rouge));
        assertTrue(yes.girls.contains(Cure.lemonade));
        assertTrue(yes.girls.contains(Cure.mint));
        assertTrue(yes.girls.contains(Cure.aqua));
    }

    @Test
    void エイリアス(){
        assertEquals(Precure.yes, Precure.find("yes_precure_five"));
        assertEquals(Precure.yes, Precure.find("yes_precure5"));
    }

    @Test
    void onAir(){
        var yes = Precure.yes;
        assertFalse(yes.isOnAir(LocalDate.of(2007, 2, 3)));
        assertTrue(yes.isOnAir(LocalDate.of(2007, 2, 4)));
        assertTrue(yes.isOnAir(LocalDate.of(2008, 1, 27)));
        assertFalse(yes.isOnAir(LocalDate.of(2008, 1, 28)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(yes.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2007, 7, 14));
        assertTrue(yes.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
