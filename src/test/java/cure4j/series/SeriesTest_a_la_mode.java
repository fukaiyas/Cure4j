package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_a_la_mode {

    Series aLaMode = Precure.aLaMode;

    @Test
    void 各種プロパティ(){
        assertEquals("a_la_mode", aLaMode.seriesName);
        assertEquals("キラキラ☆プリキュアアラモード", aLaMode.title);
        assertEquals(LocalDate.of(2017, 2, 5), aLaMode.startedDate);
        assertEquals(LocalDate.of(2018, 1, 28), aLaMode.endedDate);
        assertEquals(6, aLaMode.girls.size());
        assertTrue(aLaMode.girls.contains(Cure.whip));
        assertTrue(aLaMode.girls.contains(Cure.custard));
        assertTrue(aLaMode.girls.contains(Cure.gelato));
        assertTrue(aLaMode.girls.contains(Cure.macaron));
        assertTrue(aLaMode.girls.contains(Cure.chocolat));
        assertTrue(aLaMode.girls.contains(Cure.parfait));
    }

    @Test
    void エイリアス(){
        assertEquals(aLaMode, Precure.find("alamode"));
        assertEquals(aLaMode, Precure.find("kirakira_precure_a_la_mode"));
        assertEquals(aLaMode, Precure.find("kirakira_precure_alamode"));
    }

    @Test
    void onAir(){
        assertFalse(aLaMode.isOnAir(LocalDate.of(2017, 2, 4)));
        assertTrue(aLaMode.isOnAir(LocalDate.of(2017, 2, 5)));
        assertTrue(aLaMode.isOnAir(LocalDate.of(2018, 1, 28)));
        assertFalse(aLaMode.isOnAir(LocalDate.of(2018, 1, 29)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(aLaMode.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2017, 7, 18));
        assertTrue(aLaMode.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
