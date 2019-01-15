package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_happiness_charge {

    Series happinessCharge = Precure.happinessCharge;

    @Test
    void 各種プロパティ(){
        assertEquals("happiness_charge", happinessCharge.seriesName);
        assertEquals("ハピネスチャージプリキュア！", happinessCharge.title);
        assertEquals(LocalDate.of(2014, 2, 2), happinessCharge.startedDate);
        assertEquals(LocalDate.of(2015, 1, 25), happinessCharge.endedDate);
        assertEquals(4, happinessCharge.girls.size());
        assertTrue(happinessCharge.girls.contains(Cure.lovely));
        assertTrue(happinessCharge.girls.contains(Cure.princess));
        assertTrue(happinessCharge.girls.contains(Cure.honey));
        assertTrue(happinessCharge.girls.contains(Cure.fortune));
    }

    @Test
    void エイリアス(){
        assertEquals(happinessCharge, Precure.find("happiness_charge_precure"));
    }

    @Test
    void onAir(){
        assertFalse(happinessCharge.isOnAir(LocalDate.of(2014, 2, 1)));
        assertTrue(happinessCharge.isOnAir(LocalDate.of(2014, 2, 2)));
        assertTrue(happinessCharge.isOnAir(LocalDate.of(2015, 1, 25)));
        assertFalse(happinessCharge.isOnAir(LocalDate.of(2015, 1, 26)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(happinessCharge.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2014, 7, 18));
        assertTrue(happinessCharge.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
