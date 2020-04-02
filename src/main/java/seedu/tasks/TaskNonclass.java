package seedu.tasks;

import seedu.calendar.CalendarParser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TaskNonclass extends Task {

    protected LocalDate date;
    protected LocalTime time;
    protected String location;
    /**
     * Initializes Task.
     *
     * @param title title of deadline if any.
     * @param description description of deadline if any.
     * @param date date in format:yyyy-mm-dd of deadline if any.
     * @param time time in format: hh:mm of deadline if any.
     * @param location location of deadline if any.
     * @param reminder reminder of deadline if any.
     */
    public TaskNonclass(String title, String description, String date, String time, String location,
                        String reminder, String category) {
        super(title,description,reminder,category);

        if (!date.isEmpty()) {
            System.out.println("Entered date!!!!!");
            setDate(date);
        }
        if (!time.isEmpty()) {
            setTime(time);
        }
        if (!location.isEmpty()) {
            setLocation(location);
        }
    }

    @Override
    public void setDate(String dateInput) throws DateTimeParseException, NumberFormatException {
        if (dateInput.isEmpty()) {
            this.date = null;
        }
        this.date = CalendarParser.convertToDate(dateInput);
    }

    @Override
    public void setTime(String timeInput) throws DateTimeParseException {
        if (timeInput.isEmpty()) {
            this.time = null;
        }
        this.time = CalendarParser.convertToTime(timeInput);
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Format the string to be correct output form.
     *
     * @return a string.
     */
    public String toString() {

        // Post condition check that there should always be a category.
        assert (category.length() != 0);

        String formattedTask = super.toString();
        if (date != null) {
            formattedTask = formattedTask + String.format(" | Date: %s", date.toString());
        }
        if (time != null) {
            formattedTask = formattedTask + String.format(" | Time: %s", time.toString());
        }
        if (location != null) {
            formattedTask = formattedTask + String.format(" | Location: %s",location);
        }
        return formattedTask;
    }

}
