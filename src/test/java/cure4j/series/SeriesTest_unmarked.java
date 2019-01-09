package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_unmarked {

    @Test
    void 各種プロパティ(){
        var unmarked = Precure.unmarked;
        assertEquals("unmarked", unmarked.seriesName);
        assertEquals("ふたりはプリキュア", unmarked.title);
        assertEquals(LocalDate.of(2004, 2, 1), unmarked.startedDate);
        assertEquals(LocalDate.of(2005, 1, 30), unmarked.endedDate);
        assertEquals(2, unmarked.girls.size());
        assertTrue(unmarked.girls.contains(Cure.black));
        assertTrue(unmarked.girls.contains(Cure.white));
    }

    @Test
    void エイリアス(){
        assertEquals(Precure.unmarked, Precure.find("futari_wa_pretty_cure"));
        assertEquals(Precure.unmarked, Precure);
    }

    @Test
    void onAir(){
        var unmarked = Precure.unmarked;
        assertFalse(unmarked.isOnAir("2004/1/31"));
        assertTrue(unmarked.isOnAir("2004/2/1"));
        assertTrue(unmarked.isOnAir("2005/1/30"));
        assertFalse(unmarked.isOnAir("2005/1/31"));

        DateUtil.setDefaultCurrentDate();
        assertFalse(unmarked.isOnAir());

        DateUtil.setCurrentDate("2004/7/14");
        assertTrue(unmarked.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }

    @Test
    void 未来日付は例外(){
        var unmarked = Precure.unmarked;
        DateUtil.setCurrentDate("2019/1/8");
        assertThrows(IllegalArgumentException.class, () -> unmarked.isOnAir("2100/1/1"));
        DateUtil.setDefaultCurrentDate();
    }
}
