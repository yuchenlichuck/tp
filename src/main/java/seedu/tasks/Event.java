package seedu.tasks;

public class Event extends Task {

    private String eventDetails;

    public Event(String title, String description, String eventDetails) {
        super(title, description);
        setEventDetails(eventDetails);
    }


    private void setEventDetails(String eventDetails) {
        if (description.length() == 0) {
            this.eventDetails = "(No Event Details)";
        } else {
            this.eventDetails = eventDetails;
        }
    }

    @Override
    public String toString() {
        String formattedEvent = String.format(super.toString() + " | Event Details: %s", eventDetails);

        return formattedEvent;
    }
}
