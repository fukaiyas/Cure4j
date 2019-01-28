package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_hugtto {

    Series hugtto = Precure.hugtto;

    @Test
    void 各種プロパティ(){
        assertEquals("hugtto", hugtto.seriesName);
        assertEquals("ＨＵＧっと！プリキュア", hugtto.title);
        assertEquals(LocalDate.of(2018, 2, 4), hugtto.startedDate);
        assertEquals(LocalDate.of(2019, 1, 27), hugtto.endedDate);
        assertEquals(5, hugtto.girls.size());
        assertTrue(hugtto.girls.contains(Cure.yell));
        assertTrue(hugtto.girls.contains(Cure.ange));
        assertTrue(hugtto.girls.contains(Cure.etoile));
        assertTrue(hugtto.girls.contains(Cure.macherie));
        assertTrue(hugtto.girls.contains(Cure.amour));
    }

    @Test
    void エイリアス(){
        assertEquals(hugtto, Precure.find("hugtto_precure"));
    }

    @Test
    void onAir(){
        assertFalse(hugtto.isOnAir(LocalDate.of(2018, 2, 3)));
        assertTrue(hugtto.isOnAir(LocalDate.of(2018, 2, 4)));
        assertTrue(hugtto.isOnAir(LocalDate.of(2019, 1, 27)));
        assertFalse(hugtto.isOnAir(LocalDate.of(2019, 1, 28)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(hugtto.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2018, 8, 8));
        assertTrue(hugtto.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
