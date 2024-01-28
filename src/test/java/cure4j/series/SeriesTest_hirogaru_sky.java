package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_hirogaru_sky {

    Series hirogaru_sky = Precure.hirogaruSky;

    @Test
    void 各種プロパティ(){
        assertEquals("hirogaru_sky", hirogaru_sky.seriesName);
        assertEquals("ひろがるスカイ！プリキュア", hirogaru_sky.title);
        assertEquals(LocalDate.of(2023, 2, 5), hirogaru_sky.startedDate);
        assertEquals(LocalDate.of(2024, 1, 28), hirogaru_sky.endedDate);
        assertEquals(5, hirogaru_sky.girls.size());
        assertTrue(hirogaru_sky.girls.contains(Cure.sky));
        assertTrue(hirogaru_sky.girls.contains(Cure.prism));
        assertTrue(hirogaru_sky.girls.contains(Cure.wing));
        assertTrue(hirogaru_sky.girls.contains(Cure.butterfly));
        assertTrue(hirogaru_sky.girls.contains(Cure.majesty));
    }

    @Test
    void エイリアス(){
        assertEquals(hirogaru_sky, Precure.find("hirogaru_sky_precure"));
    }

    @Test
    void onAir(){
        assertFalse(hirogaru_sky.isOnAir(LocalDate.of(2023, 2, 4)));
        assertTrue(hirogaru_sky.isOnAir(LocalDate.of(2023, 2, 5)));
        assertTrue(hirogaru_sky.isOnAir(LocalDate.of(2024, 1, 28)));
        assertFalse(hirogaru_sky.isOnAir(LocalDate.of(2024, 1, 29)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(hirogaru_sky.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2023, 7, 14));
        assertTrue(hirogaru_sky.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
