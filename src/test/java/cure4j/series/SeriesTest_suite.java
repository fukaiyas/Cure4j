package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_suite {

    Series suite = Precure.suite;

    @Test
    void 各種プロパティ(){
        assertEquals("suite", suite.seriesName);
        assertEquals("スイートプリキュア♪", suite.title);
        assertEquals(LocalDate.of(2011, 2, 6), suite.startedDate);
        assertEquals(LocalDate.of(2012, 1, 29), suite.endedDate);
        assertEquals(4, suite.girls.size());
        assertTrue(suite.girls.contains(Cure.melody));
        assertTrue(suite.girls.contains(Cure.rhythm));
        assertTrue(suite.girls.contains(Cure.beat));
        assertTrue(suite.girls.contains(Cure.muse));
    }

    @Test
    void エイリアス(){
        assertEquals(suite, Precure.find("suite_precure"));
    }

    @Test
    void onAir(){
        assertFalse(suite.isOnAir(LocalDate.of(2011, 2, 5)));
        assertTrue(suite.isOnAir(LocalDate.of(2011, 2, 6)));
        assertTrue(suite.isOnAir(LocalDate.of(2012, 1, 29)));
        assertFalse(suite.isOnAir(LocalDate.of(2011, 1, 30)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(suite.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2011, 7, 18));
        assertTrue(suite.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
