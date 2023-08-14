package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest_delicious_party {

    Series delicious_party = Precure.deliciousParty;

    @Test
    void 各種プロパティ(){
        assertEquals("delicious_party", delicious_party.seriesName);
        assertEquals("デリシャスパーティ♥プリキュア", delicious_party.title);
        assertEquals(LocalDate.of(2022, 2, 6), delicious_party.startedDate);
//        assertEquals(LocalDate.of(2023, 1, 29), delicious_party.endedDate);
        assertEquals(4, delicious_party.girls.size());
        assertTrue(delicious_party.girls.contains(Cure.precious));
        assertTrue(delicious_party.girls.contains(Cure.spicy));
        assertTrue(delicious_party.girls.contains(Cure.yumyum));
    }

    @Test
    void エイリアス(){
        assertEquals(delicious_party, Precure.find("delicious_party_precure"));
    }

    @Test
    void onAir(){
        assertFalse(delicious_party.isOnAir(LocalDate.of(2022, 2, 5)));
        assertTrue(delicious_party.isOnAir(LocalDate.of(2022, 2, 6)));
//        assertTrue(delicious_party.isOnAir(LocalDate.of(2023, 1, 29)));
//        assertFalse(delicious_party.isOnAir(LocalDate.of(2023, 1, 30)));

        DateUtil.setDefaultCurrentDate();
        assertTrue(delicious_party.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2022, 7, 14));
        assertTrue(delicious_party.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}
