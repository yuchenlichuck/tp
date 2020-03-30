package seedu.calendar;

import java.util.Calendar;

/**
 *  Class to support date and calendar relation methods
 */
public class CalendarParser {

    public static final int DAY_OFFSET = 1;
    Calendar calendar = Calendar.getInstance();

    /**
     * Default constructor
     */
    public CalendarParser() {

    }

    /**
     * Constructor to accept user input for month
     * @param month which month to check calendar
     */
    public CalendarParser(int month) {
        if (month < 0 || month > 11) {
            calendar.get(Calendar.MONTH); //set default to current month if any error
        } else {
            calendar.set(2020, month - 1, 1);
        }
    }

    /**
     * Get the first day requested month
     * @return 0 for Sunday, 6 for Saturday
     */
    public int getFirstDay() {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.get(Calendar.DAY_OF_WEEK) - DAY_OFFSET; //Sunday is first day, 1
    }

    /**
     *  Get total number of days for requested month
     * @return max days in month
     */
    public int getTotalDays() {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH); //Sunday is first day, 1
    }

    /**
     *  Total number of weeks in month
     * @return number of weeks
     */
    public int getTotalWeeks() {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

    /**
     *  Check which month is selected
     * @return number of weeks
     */
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }
}
