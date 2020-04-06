package seedu.tasks;

import seedu.calendar.CalendarParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class TaskNonclass extends Task {

    private boolean isDateSet = false; // let us set a default without printing if user didnt set
    private boolean isTimeSet = false;

    /**
     * Initializes Task.
     *
     * @param title title of task if any.
     * @param description description of task if any.
     * @param date date in format:yyyy-mm-dd of task if any.
     * @param time time in format: hh:mm of task if any.
     * @param location location of task if any.
     * @param reminder reminder of task if any.
     * @param category category of task. If no input, default is TODO.
     */
    public TaskNonclass(String title, String description, String date, String time, String location,
                        String reminder, String category) {
        super(title,description,time,location,reminder,category);
        //set default date to date inserted
        if (!date.isEmpty()) {
            setDate(date);
        }
        if (!time.isEmpty()) {
            setTime(time);
        }

    }

    @Override
    public void setDate(String dateInput) throws DateTimeParseException, NumberFormatException {
        this.date.clear();
        if (!dateInput.isEmpty()) {
            String[] dates = dateInput.split("\\s+");
            for (String date : dates) {
                LocalDate addedDate = CalendarParser.convertToDate(date);
                if (addedDate.compareTo(LocalDate.now()) < 0) {
                    throw new NumberFormatException("Please enter a date that is either today or in the future.");
                }
                this.date.add(addedDate);
                isDateSet = true;
            }
        }
    }

    /**
     * Format the string to be correct output form.
     *
     * @return a string.
     */
    public String toString() {
        String formattedTask = super.toString();
        for (int i = 0; i < date.size(); i++) {
            if (time.size() != 0) {
                formattedTask = formattedTask + String.format(" | %s : %s - %s",
                        date.get(i), time.get(i * 2), time.get(i * 2 + 1));
            } else {
                formattedTask = formattedTask + String.format(" | %s", date.get(i));
            }
            if (location.size() > i) {
                formattedTask = formattedTask + String.format(" ( %s )",location.get(i));
            }
        }
        return formattedTask;
    }

}
