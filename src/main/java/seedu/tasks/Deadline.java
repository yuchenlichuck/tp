package seedu.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Deadline extends Task {

    private String date;
    private String time;
    private String location;
    private String reminder;

    public Deadline(String title, String description, String date,String time, String location, String reminder) {
        super(title, description);
        if (ifHasInput(date)) {
            setDate(date);
        } else {
            this.date = date;
        }
        if(ifHasInput(time)) {
            setTime(time);
        } else {
            this.time = time;
        }
        this.location = location;
        this.reminder = reminder;
    }

    private Boolean ifHasInput(String input) {
        if(input.length() == 0) {
            return false;
        }
        return true;
    }

    private void setTime(String time) {
        try {
            DateFormat originalFormat = new SimpleDateFormat("hh:mm");
            Date oringialTime = originalFormat.parse(time);
            DateFormat newFormat = new SimpleDateFormat("hh.mm aa", Locale.US);
            this.time = newFormat.format(oringialTime).toString();
        } catch (ParseException e) {
            this.time = "(Unknown time)";
        }

    }

    private void setDate(String date) {

        try {

            String[] dateInfo = date.split("-");

            int day = Integer.parseInt(dateInfo[0].trim());
            int month = Integer.parseInt(dateInfo[1].trim());
            int year = Integer.parseInt(dateInfo[2].trim());

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




    @Override
    public String toString() {
        String formattedDeadline = String.format("Title: %s | Description: %s", title, description);
        if(ifHasInput(date)) {
            formattedDeadline = formattedDeadline + String.format(" | Date: %s", date);
        }
        if(ifHasInput(time)) {
            formattedDeadline = formattedDeadline + String.format(" | Time: %s", time);
        }
        if(ifHasInput(location)) {
            formattedDeadline = formattedDeadline + String.format(" | Location: %s",location);
        }
        if(ifHasInput(reminder)) {
            formattedDeadline = formattedDeadline + String.format(" | Reminder: %s",reminder);
        }

        return formattedDeadline;
    }
}
