package Application.programs;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class DurationEx implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek day = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        System.out.println(day);
        int dayOfWeek=1;
        if(day==DayOfWeek.FRIDAY)  dayOfWeek=3;
        else if(day==DayOfWeek.SUNDAY) dayOfWeek=2;
        return temporal.plus(dayOfWeek, ChronoUnit.DAYS);
    }
}
