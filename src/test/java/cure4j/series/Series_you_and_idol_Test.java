package cure4j.series;

import cure4j.internal.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cure4j.Cure4j.Cure;
import static cure4j.Cure4j.Precure;
import static org.junit.jupiter.api.Assertions.*;

public class Series_you_and_idol_Test {

    Series you_and_idol = Precure.youAndIdol;

    @Test
    void 各種プロパティ(){
        assertEquals("you_and_idol", you_and_idol.seriesName);
        assertEquals("キミとアイドルプリキュア♪", you_and_idol.title);
        assertEquals(LocalDate.of(2025, 2, 2), you_and_idol.startedDate);
        assertNull(you_and_idol.endedDate);
        assertEquals(5, you_and_idol.girls.size());
        assertTrue(you_and_idol.girls.contains(Cure.idol));
        assertTrue(you_and_idol.girls.contains(Cure.wink));
        assertTrue(you_and_idol.girls.contains(Cure.kyunkyun));
        assertTrue(you_and_idol.girls.contains(Cure.zukyoon));
        assertTrue(you_and_idol.girls.contains(Cure.kiss));
    }

    @Test
    void エイリアス(){
        assertEquals(you_and_idol, Precure.find("you_and_idol_precure"));
        assertEquals(you_and_idol, Precure.find("kimi_to_idol"));
        assertEquals(you_and_idol, Precure.find("kimi_to_idol_precure"));
    }

    @Test
    void onAir(){
        assertFalse(you_and_idol.isOnAir(LocalDate.of(2025, 2, 1)));
        assertTrue(you_and_idol.isOnAir(LocalDate.of(2025, 2, 2)));
        // 最終放映日
        // 最終放映日 + 1

        DateUtil.setCurrentDate(LocalDate.of(2025, 7, 20));
        you_and_idol.isOnAir();
        DateUtil.setDefaultCurrentDate();
    }
}
