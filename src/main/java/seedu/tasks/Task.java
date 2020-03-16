package seedu.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class Task {

    protected String title;
    protected String description;
    protected String date;
    protected String time;
    protected String location;
    protected String reminder;

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
    public Task(String title, String description, String date,String time, String location, String reminder) {
        if (hasInput(date)) {
            setDate(date);
        } else {
            this.date = date;
        }
        if (hasInput(time)) {
            setTime(time);
        } else {
            this.time = time;
        }
        this.title = title;
        this.description = description;
        this.location = location;
        this.reminder = reminder;
    }

    /**
     * Check if a field is empty of not.
     *
     * @param input a field.
     * @return true if it is not empty.
     */
    private Boolean hasInput(String input) {
        if (input.length() == 0) {
            return false;
        }
        return true;
    }

    //Mutator methods:

    /**
     * Sets time to format: hh.mm aa
     *
     * @param time input time with accepted format: hh:mm
     */
    public void setTime(String time) {
        try {
            DateFormat originalFormat = new SimpleDateFormat("hh:mm");
            Date oringialTime = originalFormat.parse(time);
            DateFormat newFormat = new SimpleDateFormat("hh.mm aa", Locale.US);
            this.time = newFormat.format(oringialTime).toString();
        } catch (ParseException e) {
            this.time = "(Unknown time)";
        }

    }

    /**
     * Set Date to format:yyyy-mm-dd and check if date is correct.
     *
     * @param date input date
     */
    public void setDate(String date) {

        try {

            String[] dateInfo = date.split("-");

            int year = Integer.parseInt(dateInfo[0].trim());
            int month = Integer.parseInt(dateInfo[1].trim());
            int day = Integer.parseInt(dateInfo[2].trim());

            if (!(day >= 1 && day <= 30)) {
                throw new NumberFormatException();
            }

            if (!(month >= 1 && month <= 12)) {
                throw new NumberFormatException();
            }

            this.date = date;

        } catch (NumberFormatException e) {
            this.date = "(Unknown Date)";
        } catch (IndexOutOfBoundsException e) {
            this.date = "(Unknown Date)";
        }
    }

    /**
     * Sets the task description.
     *
     * @param description new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    //Accessors:

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public String getLocation() {
        return this.location;
    }

    public String getReminder() {
        return this.reminder;
    }

    /**
     * Output correct string format when listing tasks.
     *
     * @return correct format in string.
     */
    public String toString() {
        String formattedDeadline = String.format("Title: %s", title);
        if (hasInput(description)) {
            formattedDeadline = formattedDeadline + String.format(" | Description: %s", description);
        }
        if (hasInput(date)) {
            formattedDeadline = formattedDeadline + String.format(" | Date: %s", date);
        }
        if (hasInput(time)) {
            formattedDeadline = formattedDeadline + String.format(" | Time: %s", time);
        }
        if (hasInput(location)) {
            formattedDeadline = formattedDeadline + String.format(" | Location: %s",location);
        }
        if (hasInput(reminder)) {
            formattedDeadline = formattedDeadline + String.format(" | Reminder: %s",reminder);
        }

        return formattedDeadline;
    }

}