package seedu.command;

import seedu.tasks.Deadline;
import seedu.tasks.Event;

public class EventCommand extends AddCommand {

    private String userInput;

    public EventCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() {

        String title = getTitle(userInput);
        String eventDetails = getDate(userInput);
        String description = getDescription(userInput);

        taskList.addTask(new Event(title, description, eventDetails));

        return new CommandResult("Added event");
    }

}
