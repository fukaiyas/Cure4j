package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_dokidoki {

    Series dokidoki = Precure.dokidoki;

    @Test
    void 各種プロパティ(){
        assertEquals("dokidoki", dokidoki.seriesName);
        assertEquals("ドキドキ！プリキュア", dokidoki.title);
        assertEquals(LocalDate.of(2013, 2, 3), dokidoki.startedDate);
        assertEquals(LocalDate.of(2014, 1, 26), dokidoki.endedDate);
        assertEquals(5, dokidoki.girls.size());
        assertTrue(dokidoki.girls.contains(Cure.heart));
        assertTrue(dokidoki.girls.contains(Cure.diamond));
        assertTrue(dokidoki.girls.contains(Cure.rosetta));
        assertTrue(dokidoki.girls.contains(Cure.sword));
        assertTrue(dokidoki.girls.contains(Cure.ace));
    }

    @Test
    void エイリアス(){
        assertEquals(dokidoki, Precure.find("dokidoki_precure"));
    }

    @Test
    void onAir(){
        assertFalse(dokidoki.isOnAir(LocalDate.of(2013, 2, 2)));
        assertTrue(dokidoki.isOnAir(LocalDate.of(2013, 2, 3)));
        assertTrue(dokidoki.isOnAir(LocalDate.of(2014, 1, 26)));
        assertFalse(dokidoki.isOnAir(LocalDate.of(2014, 1, 27)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(dokidoki.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2013, 7, 14));
        assertTrue(dokidoki.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
