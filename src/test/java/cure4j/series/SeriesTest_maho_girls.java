package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_maho_girls {

    Series mahoGirls = Precure.mahoGirls;

    @Test
    void 各種プロパティ(){
        assertEquals("maho_girls", mahoGirls.seriesName);
        assertEquals("魔法つかいプリキュア！", mahoGirls.title);
        assertEquals(LocalDate.of(2016, 2, 7), mahoGirls.startedDate);
        assertEquals(LocalDate.of(2017, 1, 29), mahoGirls.endedDate);
        assertEquals(3, mahoGirls.girls.size());
        assertTrue(mahoGirls.girls.contains(Cure.miracle));
        assertTrue(mahoGirls.girls.contains(Cure.magical));
        assertTrue(mahoGirls.girls.contains(Cure.felice));
    }

    @Test
    void エイリアス(){
        assertEquals(mahoGirls, Precure.find("maho_girls_precure"));
    }

    @Test
    void onAir(){
        assertFalse(mahoGirls.isOnAir(LocalDate.of(2016, 2, 6)));
        assertTrue(mahoGirls.isOnAir(LocalDate.of(2016, 2, 7)));
        assertTrue(mahoGirls.isOnAir(LocalDate.of(2017, 1, 29)));
        assertFalse(mahoGirls.isOnAir(LocalDate.of(2017, 1, 30)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(mahoGirls.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2016, 7, 14));
        assertTrue(mahoGirls.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
