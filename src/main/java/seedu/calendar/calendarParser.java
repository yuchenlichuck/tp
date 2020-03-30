package seedu.calendar;

import java.util.Calendar;
import java.util.Date;

public class calendarParser {

    public static final int DAY_OFFSET = 1;
    Calendar calendar = Calendar.getInstance();

    public calendarParser() {

    }

    public calendarParser(int month) {
        if (month < 0 || month > 11) {
            month = calendar.get(Calendar.MONTH); //set default to current month if any error
        } else {
            calendar.set(2020, month - 1, 1);
        }
    }

    public int getFirstDay() {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.get(Calendar.DAY_OF_WEEK) - DAY_OFFSET; //Sunday is first day, 1
    }

    public int getTotalDays() {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH); //Sunday is first day, 1
    }

    public int getTotalWeeks() {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }


}
