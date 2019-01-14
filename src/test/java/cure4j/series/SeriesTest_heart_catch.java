package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_heart_catch {

    Series heartCatch = Precure.heartCatch;

    @Test
    void 各種プロパティ(){
        assertEquals("heart_catch", heartCatch.seriesName);
        assertEquals("ハートキャッチプリキュア！", heartCatch.title);
        assertEquals(LocalDate.of(2010, 2, 7), heartCatch.startedDate);
        assertEquals(LocalDate.of(2011, 1, 30), heartCatch.endedDate);
        assertEquals(4, heartCatch.girls.size());
        assertTrue(heartCatch.girls.contains(Cure.blossom));
        assertTrue(heartCatch.girls.contains(Cure.marine));
        assertTrue(heartCatch.girls.contains(Cure.sunshine));
        assertTrue(heartCatch.girls.contains(Cure.moonlight));
    }

    @Test
    void エイリアス(){
        assertEquals(heartCatch, Precure.find("heart_catch_precure"));
    }

    @Test
    void onAir(){
        assertFalse(heartCatch.isOnAir(LocalDate.of(2010, 2, 6)));
        assertTrue(heartCatch.isOnAir(LocalDate.of(2010, 2, 7)));
        assertTrue(heartCatch.isOnAir(LocalDate.of(2011, 1, 30)));
        assertFalse(heartCatch.isOnAir(LocalDate.of(2011, 1, 31)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(heartCatch.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2010, 7, 14));
        assertTrue(heartCatch.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
