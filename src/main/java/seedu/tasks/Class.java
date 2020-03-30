package seedu.tasks;

public class Class extends Task {

    public Class(String title, String description, String date, String time, String location,
                        String reminder, String category) {
        super(title,description,reminder,category,date,time,location);
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