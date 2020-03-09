package seedu.tasks;

public abstract class Task {

    protected String title;
    protected String description;

    public Task (String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    private void setTitle (String title) {
        if (title.length() == 0) {
            this.title = "(No Title)";
        } else {
            this.title = title;
        }
    }

    private void setDescription(String description) {
        if (description.length() == 0) {
            this.description = "(No Description)";
        } else {
            this.description = description;
        }
    }

    @Override
    public String toString () {
        String formattedTask = String.format("Title: %s | Description: %s", title, description);

        return formattedTask;
    }

}
