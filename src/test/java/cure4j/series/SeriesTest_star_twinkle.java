package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_star_twinkle {

    Series starTwinkle = Precure.starTwinkle;

    @Test
    void 各種プロパティ(){
        assertEquals("star_twinkle", starTwinkle.seriesName);
        assertEquals("スター☆トゥインクルプリキュア", starTwinkle.title);
        assertEquals(LocalDate.of(2019, 2, 3), starTwinkle.startedDate);
        assertEquals(LocalDate.of(2020, 1, 26), starTwinkle.endedDate);
        assertEquals(5, starTwinkle.girls.size());
        assertTrue(starTwinkle.girls.contains(Cure.star));
        assertTrue(starTwinkle.girls.contains(Cure.milky));
        assertTrue(starTwinkle.girls.contains(Cure.soleil));
        assertTrue(starTwinkle.girls.contains(Cure.selene));
        assertTrue(starTwinkle.girls.contains(Cure.cosmo));
    }

    @Test
    void エイリアス(){
        assertEquals(starTwinkle, Precure.find("star_twinkle_precure"));
    }

    @Test
    void onAir(){
        assertFalse(starTwinkle.isOnAir(LocalDate.of(2019, 2, 2)));
        assertTrue(starTwinkle.isOnAir(LocalDate.of(2019, 2, 3)));
        assertTrue(starTwinkle.isOnAir(LocalDate.of(2020, 1, 26)));
        assertFalse(starTwinkle.isOnAir(LocalDate.of(2020, 1, 27)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(starTwinkle.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2019, 8, 8));
        assertTrue(starTwinkle.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
