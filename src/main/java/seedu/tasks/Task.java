package seedu.tasks;

import seedu.exception.ProjException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static seedu.common.Constants.DEFAULT_CATEGORY;

public class Task {
    protected String title;
    protected String description;
    protected String reminder;
    protected String category;
    protected ArrayList<String> date = new ArrayList<String>();
    protected ArrayList<String> time = new ArrayList<String>();
    protected ArrayList<String> location = new ArrayList<String>();

    /**
     * Initialize task based on its category.
     *
     * @param title title of class.
     * @param description description of class if any.
     * @param reminder reminder of class if any.
     * @param category category of class. Default is TODO.
     * @param date date of class if any.
     * @param time time of class if any.
     * @param location location of class if any.
     */
    public Task(String title, String description, String reminder, String category,
                String date, String time, String location) {
        if (hasInput(category)) {
            this.category = category.trim().toUpperCase();
        } else {
            this.category = DEFAULT_CATEGORY;
        }
        // post condition check for existence of title
        assert (title.length() != 0) : title;
        this.title = title;
        this.description = description;
        this.reminder = reminder;

        if (hasInput(date)) {
            setDate(date);
        }
        if (hasInput(time)) {
            setTime(time);
        }
        if (hasInput(location)) {
            setLocation(location);

        }
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

    /**
     * Set Date to format:yyyy-mm-dd and check if date is correct.
     *
     * @param date input date
     */
    public void setDate(String date) {
        if (this.category.equals("CLASS")) {
            String[] days = date.split("\\s+");
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
            try {
                String[] dateInfo = date.split("-");

                int month = Integer.parseInt(dateInfo[1].trim());
                int day = Integer.parseInt(dateInfo[2].trim());

                if (!(day >= 1 && day <= 30)) {
                    throw new NumberFormatException();
                }

                if (!(month >= 1 && month <= 12)) {
                    throw new NumberFormatException();
                }

                this.date.add(date);

            } catch (NumberFormatException e) {
                this.date.add("(Unknown Date)");
            } catch (IndexOutOfBoundsException e) {
                this.date.add("(Unknown Date)");
            }
        }
    }

    /**
     * Sets time to format: hh.mm aa
     *
     * @param time input time with accepted format: hh:mm
     */
    public void setTime(String time) {
        if (this.category.equals("CLASS")) {
            String[] timeInfo = time.split("\\s+");
            for (String atime : timeInfo) {
                this.time.add(atime);
            }
        } else {
            this.time.clear();
            try {
                DateFormat originalFormat = new SimpleDateFormat("hh:mm");
                Date oringialTime = originalFormat.parse(time);
                DateFormat newFormat = new SimpleDateFormat("hh.mm aa", Locale.US);
                this.time.add(newFormat.format(oringialTime));
            } catch (ParseException e) {
                this.time.add("(Unknown time)");
            }
        }
    }

    /**
     * Set the input location to right format.
     * It it is a class, the location will be split to different part.
     *
     * @param location input location.
     */
    public void setLocation(String location) {
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


    //Accessors:
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReminder() {
        return this.reminder;
    }

    public String getCategory() {
        return this.category;
    }

    public ArrayList<String> getDate() {
        return this.date;
    }

    public ArrayList<String> getTime() {
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
        String formattedTask = String.format("[%s] Title: %s", category.toUpperCase().trim(),title.trim());
        if (hasInput(description)) {
            formattedTask = formattedTask + String.format(" | Description: %s", description);
        }
        if (hasInput(reminder)) {
            formattedTask = formattedTask + String.format(" | Reminder: %s",reminder);
        }
        return formattedTask;
    }
}
