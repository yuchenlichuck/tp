package seedu.tasks;

public class Todo extends Task {

    /**
     * Initializes Todo task.
     *
     * @param title title of deadline if any.
     * @param description description of deadline if any.
     * @param date date in format:yyyy-mm-dd of deadline if any.
     * @param time time in format: hh:mm of deadline if any.
     * @param location location of deadline if any.
     * @param reminder reminder of deadline if any.
     */
    public Todo(String title, String description, String date,String time, String location, String reminder) {
        super(title, description,date,time,location,reminder);
    }

}
