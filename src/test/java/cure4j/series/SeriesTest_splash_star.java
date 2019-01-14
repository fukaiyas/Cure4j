package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_splash_star {

    Series splashStar = Precure.splashStar;

    @Test
    void 各種プロパティ(){
        assertEquals("splash_star", splashStar.seriesName);
        assertEquals("ふたりはプリキュア Splash☆Star", splashStar.title);
        assertEquals(LocalDate.of(2006, 2, 5), splashStar.startedDate);
        assertEquals(LocalDate.of(2007, 1, 28), splashStar.endedDate);
        assertEquals(2, splashStar.girls.size());
        assertTrue(splashStar.girls.contains(Cure.bloom));
        assertTrue(splashStar.girls.contains(Cure.egret));
    }

    @Test
    void エイリアス(){
        assertEquals(splashStar, Precure.find("futari_wa_pretty_cure_splash_star"));
    }

    @Test
    void onAir(){
        assertFalse(splashStar.isOnAir(LocalDate.of(2006, 2, 4)));
        assertTrue(splashStar.isOnAir(LocalDate.of(2006, 2, 5)));
        assertTrue(splashStar.isOnAir(LocalDate.of(2007, 1, 28)));
        assertFalse(splashStar.isOnAir(LocalDate.of(2007, 1, 29)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(splashStar.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2006, 8, 8));
        assertTrue(splashStar.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
