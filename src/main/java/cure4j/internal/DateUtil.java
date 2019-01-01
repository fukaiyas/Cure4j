package cure4j.internal;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateUtil {
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();
    private static final List<DateTimeFormatter> FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("yyyy/M/d"),
            DateTimeFormatter.ofPattern("yyyyMMdd")
    );

    private static Clock currentClock = Clock.systemDefaultZone();

    public static LocalDate currentDate(){
        return LocalDate.now(currentClock);
    }

    public static void setCurrentDate(CharSequence date){
        LocalDate localDate = parseDate(date);
        currentClock = Clock.fixed(
                localDate.atStartOfDay(DEFAULT_ZONE_ID).toInstant(), DEFAULT_ZONE_ID);
    }

    public static void setDefaultCurrentDate(){
        currentClock = Clock.systemDefaultZone();
    }

    public static LocalDate parseDate(CharSequence date){
        for(DateTimeFormatter formatter : FORMATTERS){
            try{
                return LocalDate.parse(date, formatter);
            }catch(Exception e){
                //Ignore exception
            }
        }
        return LocalDate.parse(date);
    }
}
