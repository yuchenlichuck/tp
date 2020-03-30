package seedu.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskNonclass extends Task {

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
        super(title,description,reminder,category,date,time,location);
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
        if (date.size() != 0) {
            formattedTask = formattedTask + String.format(" | Date: %s", date.get(0));
        }
        if (time.size() != 0) {
            formattedTask = formattedTask + String.format(" | Time: %s", time.get(0));
        }
        if (location.size() != 0) {
            formattedTask = formattedTask + String.format(" | Location: %s",location.get(0));
        }
        return formattedTask;
    }

}
