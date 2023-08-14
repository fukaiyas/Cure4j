package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_tropical_rouge {

    Series tropical_rouge = Precure.tropicalRouge;

    @Test
    void 各種プロパティ(){
        assertEquals("tropical_rouge", tropical_rouge.seriesName);
        assertEquals("トロピカル～ジュ！プリキュア", tropical_rouge.title);
        assertEquals(LocalDate.of(2021, 2, 28), tropical_rouge.startedDate);
        assertEquals(LocalDate.of(2022, 1, 30), tropical_rouge.endedDate);
        assertEquals(5, tropical_rouge.girls.size());
        assertTrue(tropical_rouge.girls.contains(Cure.summer));
        assertTrue(tropical_rouge.girls.contains(Cure.coral));
        assertTrue(tropical_rouge.girls.contains(Cure.papaya));
        assertTrue(tropical_rouge.girls.contains(Cure.flamingo));
        assertTrue(tropical_rouge.girls.contains(Cure.lamer));
    }

    @Test
    void エイリアス(){
        assertEquals(tropical_rouge, Precure.find("tropical_rouge_precure"));
    }

    @Test
    void onAir(){
        assertFalse(tropical_rouge.isOnAir(LocalDate.of(2021, 2, 27)));
        assertTrue(tropical_rouge.isOnAir(LocalDate.of(2021, 2, 28)));
        assertTrue(tropical_rouge.isOnAir(LocalDate.of(2022, 1, 30)));
        assertFalse(tropical_rouge.isOnAir(LocalDate.of(2022, 1, 31)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(tropical_rouge.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2021, 7, 14));
        assertTrue(tropical_rouge.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
