package seedu.command;

import seedu.exception.ProjException;
import seedu.tasks.Deadline;

public class DeadlineCommand extends AddCommand {

    private String userInput;

    public DeadlineCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() throws ProjException {

        String title = getTitle(userInput);

        if (title.length() == 0) {
            throw new ProjException("Please input a title for the deadline.");
        }

        String date = getDate(userInput);
        String description = getDescription(userInput);
        String reminder = getReminder(userInput);
        String time = getTime(userInput);
        String location = getLocation(userInput);

        taskList.addTask(new Deadline(title, description, date, time, location, reminder));

        return new CommandResult("Added deadline\n");
    }

}
