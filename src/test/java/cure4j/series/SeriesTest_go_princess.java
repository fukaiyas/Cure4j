package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_go_princess {

    Series goPrincess = Precure.goPrincess;

    @Test
    void 各種プロパティ(){
        assertEquals("go_princess", goPrincess.seriesName);
        assertEquals("Go!プリンセスプリキュア", goPrincess.title);
        assertEquals(LocalDate.of(2015, 2, 1), goPrincess.startedDate);
        assertEquals(LocalDate.of(2016, 1, 31), goPrincess.endedDate);
        assertEquals(4, goPrincess.girls.size());
        assertTrue(goPrincess.girls.contains(Cure.flora));
        assertTrue(goPrincess.girls.contains(Cure.mermaid));
        assertTrue(goPrincess.girls.contains(Cure.twinkle));
        assertTrue(goPrincess.girls.contains(Cure.scarlet));
    }

    @Test
    void エイリアス(){
        assertEquals(goPrincess, Precure.find("go_princess_precure"));
    }

    @Test
    void onAir(){
        assertFalse(goPrincess.isOnAir(LocalDate.of(2015, 1, 31)));
        assertTrue(goPrincess.isOnAir(LocalDate.of(2015, 2, 1)));
        assertTrue(goPrincess.isOnAir(LocalDate.of(2016, 1, 31)));
        assertFalse(goPrincess.isOnAir(LocalDate.of(2016, 2, 1)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(goPrincess.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2015, 8, 8));
        assertTrue(goPrincess.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
