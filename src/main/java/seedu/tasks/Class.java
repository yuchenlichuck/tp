package seedu.tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Class extends Task {
    protected ArrayList<String> date = new ArrayList<String>();
    protected ArrayList<String> time = new ArrayList<String>();
    protected ArrayList<String> location = new ArrayList<String>();

    public Class(String title, String description, String date, String time, String location,
                        String reminder, String category) {
        super(title,description,reminder,category);

        if (!date.isEmpty()) {
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
        }
    }

    @Override
    public void setTime(String time) throws DateTimeParseException {
        if (this.category.equals("CLASS")) {
            String[] timeInfo = time.split("\\s+");
            for (String atime : timeInfo) {
                this.time.add(atime);
            }
        }
    }

    @Override
    public void setLocation(String location) {
        String[] locations = location.split("\\s+");
        for (String oneLocation : locations) {
            this.location.add(oneLocation);
        }
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
     * Return string of class in its specific format.
     *
     * @return string of class.
     */
    public String toString() {

        String formattedTask = super.toString();
        for (int i = 0; i < date.size(); i++) {
            formattedTask = formattedTask + String.format(" | %s : %s", date.get(i),time.get(i));
            if (location.size() > i) {
                formattedTask = formattedTask + String.format(" ( %s )",location.get(i));
            }
        }
        return formattedTask;
    }
}