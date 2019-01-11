package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_fresh {

    @Test
    void 各種プロパティ(){
        var fresh = Precure.fresh;
        assertEquals("fresh", fresh.seriesName);
        assertEquals("フレッシュプリキュア！", fresh.title);
        assertEquals(LocalDate.of(2009, 2, 1), fresh.startedDate);
        assertEquals(LocalDate.of(2010, 1, 31), fresh.endedDate);
        assertEquals(4, fresh.girls.size());
        assertTrue(fresh.girls.contains(Cure.peach));
        assertTrue(fresh.girls.contains(Cure.berry));
        assertTrue(fresh.girls.contains(Cure.pine));
        assertTrue(fresh.girls.contains(Cure.passion));
    }

    @Test
    void エイリアス(){
        assertEquals(Precure.fresh, Precure.find("fresh_precure"));
    }

    @Test
    void onAir(){
        var fresh = Precure.fresh;
        assertFalse(fresh.isOnAir(LocalDate.of(2009, 1, 31)));
        assertTrue(fresh.isOnAir(LocalDate.of(2009, 2, 1)));
        assertTrue(fresh.isOnAir(LocalDate.of(2010, 1, 31)));
        assertFalse(fresh.isOnAir(LocalDate.of(2010, 2, 1)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(fresh.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2009, 8, 8));
        assertTrue(fresh.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
