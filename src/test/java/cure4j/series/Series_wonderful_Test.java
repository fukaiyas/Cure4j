package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class Series_wonderful_Test {

    Series wonderful = Precure.wonderful;

    @Test
    void 各種プロパティ(){
        assertEquals("wonderful", wonderful.seriesName);
        assertEquals("わんだふるぷりきゅあ！", wonderful.title);
        assertEquals(LocalDate.of(2024, 2, 4), wonderful.startedDate);
        assertEquals(LocalDate.of(2025, 1, 26), wonderful.endedDate);
        assertEquals(4, wonderful.girls.size());
        assertTrue(wonderful.girls.contains(Cure.wonderful));
        assertTrue(wonderful.girls.contains(Cure.friendy));
        assertTrue(wonderful.girls.contains(Cure.nyammy));
        assertTrue(wonderful.girls.contains(Cure.lillian));
    }

    @Test
    void エイリアス(){
        assertEquals(wonderful, Precure.find("wonderful_precure"));
    }

    @Test
    void onAir(){
        assertFalse(wonderful.isOnAir(LocalDate.of(2024, 2, 3)));
        assertTrue(wonderful.isOnAir(LocalDate.of(2024, 2, 4)));
        assertTrue(wonderful.isOnAir(LocalDate.of(2025, 1, 26)));
        assertFalse(wonderful.isOnAir(LocalDate.of(2025, 1, 27)));

        DateUtil.setDefaultCurrentDate();
        assertFalse(wonderful.isOnAir());

        DateUtil.setCurrentDate(LocalDate.of(2024, 7, 20));
        assertTrue(wonderful.isOnAir());
        DateUtil.setDefaultCurrentDate();
    }
}