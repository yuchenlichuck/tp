package seedu.tasks;

import seedu.calendar.CalendarParser;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;


public class TaskNonclass extends Task {

    public static final char TICK = 'Y'; //Yes
    public static final char CROSS = 'N'; //No

    protected LocalDate date;
    protected LocalTime time;
    protected String location;

    private boolean isDateSet = false; // let us set a default without printing if user didnt set
    private boolean isTimeSet = false;
    private boolean isDone = false;

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

        this.isDone = false;

        //set default date to date inserted
        if (!date.isEmpty()) {
            System.out.println("Have date");
            setDate(date);
        } else {
            this.date = LocalDate.now();
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
        } else {
            this.date = CalendarParser.convertToDate(dateInput);
            isDateSet = true;
        }
    }

    @Override
    public void setTime(String timeInput) throws DateTimeParseException {
        if (timeInput.isEmpty()) {
            this.time = null;
        } else {
            this.time = CalendarParser.convertToTime(timeInput);
            isTimeSet = true;
        }
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getLocation() {
        return location;
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
        if (isDateSet) {
            formattedTask = formattedTask + String.format(" | Date: %s", date.toString());
        }
        if (isTimeSet) {
            formattedTask = formattedTask + String.format(" | Time: %s", time.toString());
        }
        if (location != null) {
            formattedTask = formattedTask + String.format(" | Location: %s",location);
        }
        return formattedTask;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns symbol for status of task.
     *
     * @return tick for done, cross for not done
     */
    public char getStatusIcon() {
        return (isDone ? TICK : CROSS); //return tick or X symbols
    }


}
