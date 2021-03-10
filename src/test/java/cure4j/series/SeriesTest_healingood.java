package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_healingood {

    Series healingood = Precure.healingood;

    @Test
    void 各種プロパティ(){
        assertEquals("healingood", healingood.seriesName);
        assertEquals("ヒーリングっど♥プリキュア", healingood.title);
        assertEquals(LocalDate.of(2020, 2, 2), healingood.startedDate);
        assertEquals(LocalDate.of(2021, 2, 21), healingood.endedDate);
        assertEquals(4, healingood.girls.size());
        assertTrue(healingood.girls.contains(Cure.grace));
        assertTrue(healingood.girls.contains(Cure.fontaine));
        assertTrue(healingood.girls.contains(Cure.sparkle));
        assertTrue(healingood.girls.contains(Cure.earth));
    }

    @Test
    void エイリアス(){
        assertEquals(healingood, Precure.find("healingood_precure"));
    }

    @Test
    void onAir(){
        assertFalse(healingood.isOnAir(LocalDate.of(2020, 2, 1)));
        assertTrue(healingood.isOnAir(LocalDate.of(2020, 2, 2)));
        assertTrue(healingood.isOnAir(LocalDate.of(2021, 2, 21)));
        assertFalse(healingood.isOnAir(LocalDate.of(2021, 2, 22)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(healingood.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2020, 8, 8));
        assertTrue(healingood.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
