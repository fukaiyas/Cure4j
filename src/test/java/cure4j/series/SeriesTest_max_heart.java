package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_max_heart {

    @Test
    void 各種プロパティ(){
        var maxHeart = Precure.maxHeart;
        assertEquals("max_heart", maxHeart.seriesName);
        assertEquals("ふたりはプリキュア Max Heart", maxHeart.title);
        assertEquals(LocalDate.of(2005, 2, 6), maxHeart.startedDate);
        assertEquals(LocalDate.of(2006, 1, 29), maxHeart.endedDate);
        assertEquals(3, maxHeart.girls.size());
        assertTrue(maxHeart.girls.contains(Cure.black));
        assertTrue(maxHeart.girls.contains(Cure.white));
        assertTrue(maxHeart.girls.contains(Shiny.luminous));
    }

    @Test
    void エイリアス(){
        assertEquals(Precure.maxHeart, Precure.find("futari_wa_pretty_cure_max_heart"));
    }

    @Test
    void onAir(){
        var maxHeart = Precure.maxHeart;
        assertFalse(maxHeart.isOnAir(LocalDate.of(2005, 2, 5)));
        assertTrue(maxHeart.isOnAir(LocalDate.of(2005, 2, 6)));
        assertTrue(maxHeart.isOnAir(LocalDate.of(2006, 1, 29)));
        assertFalse(maxHeart.isOnAir(LocalDate.of(2006, 1, 30)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(maxHeart.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2005, 7, 18));
        assertTrue(maxHeart.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
