package seedu.tasks;

public class Deadline extends Task {

    private String date;

    public Deadline(String title, String description, String date) {
        super(title, description);
        setDate(date);
    }


    private void setDate(String date) {

        try {

            String[] dateInfo = date.split("/");

            int day = Integer.parseInt(dateInfo[0]);
            int month = Integer.parseInt(dateInfo[1]);
            int year = Integer.parseInt(dateInfo[2]);

            if (!(day >= 1 && day <= 30)) {
                throw new NumberFormatException();
            }

            if (!(month >= 1 && month <= 12)) {
                throw new NumberFormatException();
            }

            this.date = date;

        } catch (NumberFormatException e) {
            this.date = "(No Date)";
        } catch (IndexOutOfBoundsException e) {
            this.date = "(No Date)";
        }
    }

    @Override
    public String toString() {
        String formattedDeadline = String.format("Title: %s | Date: %s | Description: %s", title, date, description);

        return formattedDeadline;
    }
}
