package seedu.tasks;


import seedu.calendar.CalendarParser;
import seedu.exception.ProjException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import static seedu.common.Constants.DEFAULT_CATEGORY;

public abstract class Task {
    protected String title;
    protected String description;
    protected String reminder;
    protected String category;
    protected ArrayList<LocalDate> date = new ArrayList<LocalDate>();
    protected ArrayList<LocalTime> time = new ArrayList<LocalTime>();
    protected ArrayList<String> location = new ArrayList<String>();
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");


    /**
     * Initialize task based on its category.
     *
     * @param title       title of class.
     * @param description description of class if any.
     * @param reminder    reminder of class if any.
     * @param category    category of class. Default is TODO.
     */
    public Task(String title, String description, String time, String location,
                String reminder, String category) {
        if (!category.isEmpty()) {
            this.category = category.trim().toUpperCase();
        } else {
            this.category = DEFAULT_CATEGORY;
        }
        // post condition check for existence of title
        assert (title.length() != 0) : title;
        this.title = title;
        this.description = description;
        this.reminder = reminder;
        if (!time.isEmpty()) {
            setTime(time);
        }
        if (!location.isEmpty()) {
            setLocation(location);
        }

    }

    /**
     * Check if a field is empty of not.
     *
     * @param input a field.
     * @return true if it is not empty.
     */
    protected Boolean hasInput(String input) {
        if (input.length() == 0) {
            return false;
        }
        return true;
    }

    //Mutator:
    public void setDescription(String description) {
        this.description = description;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public abstract void setDate(String dateInput) throws DateTimeParseException, NumberFormatException;

    /**
     * Set time to format: hh.mm aa
     *
     * @param time input time with accepted format: hh:mm
     */
    public void setTime(String time) throws DateTimeParseException
    {
        this.time.clear();
        String[] timeInfo = time.split("\\s+");
        for (String atime : timeInfo) {
            String[] timeRange = atime.split("-");
            LocalTime startTime = LocalTime.parse(timeRange[0], timeFormatter);
            this.time.add(startTime);
            LocalTime endTime = LocalTime.parse(timeRange[1], timeFormatter);
            this.time.add(endTime);
        }
    }

    /**
     * Set the input location to right format.
     * It there are multiple time slots, the location will be split to different part.
     *
     * @param location input location.
     */
    public void setLocation(String location)
    {
        //clear the previous stored locations
        this.location.clear();
        String[] locations = location.split("\\s+");
        for (String oneLocation : locations) {
            this.location.add(oneLocation);
        }
    }

    //Accessors:
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return this.category;
    }

    public ArrayList<LocalDate> getDate() {
        return this.date;
    }

    public ArrayList<LocalTime> getTime() {
        return this.time;
    }

    public ArrayList<String> getLocation() {
        return this.location;
    }

    /**
     * Output correct string format when listing tasks.
     *
     * @return correct format in string.
     */
    public String toString() {
        // Post condition check that there should always be a category.
        assert (category.length() != 0);
        String formattedTask = String.format("[%s] Title: %s", category.toUpperCase().trim(), title.trim());
        if (hasInput(description)) {
            formattedTask = formattedTask + String.format(" | Description: %s", description);
        }
        if (hasInput(reminder)) {
            formattedTask = formattedTask + String.format(" | Reminder: %s", reminder);
        }
        return formattedTask;
    }
}
