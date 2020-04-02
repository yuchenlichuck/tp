package seedu.tasks;


import seedu.calendar.CalendarParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import static seedu.common.Constants.DEFAULT_CATEGORY;

public abstract class Task {
    protected String title;
    protected String description;
    protected String reminder;
    protected String category;



    /**
     * Initialize task based on its category.
     *
     * @param title       title of class.
     * @param description description of class if any.
     * @param reminder    reminder of class if any.
     * @param category    category of class. Default is TODO.
     * @param time        time of class if any.
     * @param location    location of class if any.
     */
    public Task(String title, String description, String reminder, String category) {
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


    }

    /**
     * Initialize task with only date and time information.
     * Used to compare dates and times.
     *
     * @param date Task date
     * @param time Task time
     */
    public Task(String date, String time) {

        this.category = "dummy";

        setDate(date);
        setTime(time);
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

  /*  {

        if (this.category.equals("CLASS")) {

            String[] days = dateInput.split("\\s+");
            for (String day : days) {
                Integer dayOfWeekInt = Integer.parseInt(day);
                if (dayOfWeekInt > 7 | dayOfWeekInt < 1) {
                    throw new NumberFormatException();
                }
                DayOfWeek dayOfWeek = DayOfWeek.of(Integer.parseInt(day));
                this.date.add(dayOfWeek.name());
            }
        } else {
            this.date.clear();
            LocalDate Date = CalendarParser.convertToDate(dateInput);
        }
    }*/

    /**
     * Set time to format: hh.mm aa
     *
     * @param time input time with accepted format: hh:mm
     */
    public abstract void setTime(String time) throws DateTimeParseException;

    /*{
        if (this.category.equals("CLASS")) {
            String[] timeInfo = time.split("\\s+");
            for (String atime : timeInfo) {
                this.time.add(atime);
            }
        } else {
            this.time.clear();
            try {
                SimpleDateFormat originalFormat = new SimpleDateFormat("HH:mm");
                //HH means 24 hours. However, hh means 12hours
                Date originalTime = originalFormat.parse(time);
                SimpleDateFormat newFormat = new SimpleDateFormat("hh.mm a");
                this.time.add(newFormat.format(originalTime));
            } catch (ParseException e) {
                this.time.add("(Unknown time)");
            }
        }
    }

     */

    /**
     * Set the input location to right format.
     * It it is a class, the location will be split to different part.
     *
     * @param location input location.
     */
    public abstract void setLocation(String location);
    /*{
        if (this.category.equals("CLASS")) {
            String[] locations = location.split("\\s+");
            for (String oneLocation : locations) {
                this.location.add(oneLocation);
            }
        } else {
            this.location.clear();
            this.location.add(location);
        }
    }
     */


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
