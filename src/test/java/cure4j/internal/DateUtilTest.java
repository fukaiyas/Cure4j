package cure4j.internal;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilTest {

    @Test
    void parseDateのテスト(){
        LocalDate expected = LocalDate.of(2011, 1, 8);
        assertEquals(expected, DateUtil.parseDate("2011/1/8"));
        assertEquals(expected, DateUtil.parseDate("2011/01/8"));
        assertEquals(expected, DateUtil.parseDate("2011/1/08"));
        assertEquals(expected, DateUtil.parseDate("2011/01/08"));
        assertEquals(expected, DateUtil.parseDate("20110108"));
        assertEquals(expected, DateUtil.parseDate("2011-01-08"));
    }

    @Test
    void parseDate例外発生(){
        assertThrows(DateTimeParseException.class, () -> DateUtil.parseDate("Bad Format"));
        assertThrows(NullPointerException.class, () -> DateUtil.parseDate(null));
    }
}
