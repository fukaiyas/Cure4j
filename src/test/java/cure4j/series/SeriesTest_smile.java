package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_smile {

    Series smile = Precure.smile;

    @Test
    void 各種プロパティ(){
        assertEquals("smile", smile.seriesName);
        assertEquals("スマイルプリキュア！", smile.title);
        assertEquals(LocalDate.of(2012, 2, 5), smile.startedDate);
        assertEquals(LocalDate.of(2013, 1, 27), smile.endedDate);
        assertEquals(5, smile.girls.size());
        assertTrue(smile.girls.contains(Cure.happy));
        assertTrue(smile.girls.contains(Cure.sunny));
        assertTrue(smile.girls.contains(Cure.peace));
        assertTrue(smile.girls.contains(Cure.march));
        assertTrue(smile.girls.contains(Cure.beauty));
    }

    @Test
    void エイリアス(){
        assertEquals(smile, Precure.find("smile_precure"));
    }

    @Test
    void onAir(){
        assertFalse(smile.isOnAir(LocalDate.of(2012, 2, 4)));
        assertTrue(smile.isOnAir(LocalDate.of(2012, 2, 5)));
        assertTrue(smile.isOnAir(LocalDate.of(2013, 1, 27)));
        assertFalse(smile.isOnAir(LocalDate.of(2013, 1, 28)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(smile.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2012, 8, 8));
        assertTrue(smile.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
