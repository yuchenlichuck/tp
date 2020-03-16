package seedu.command;

import seedu.exception.ProjException;
import seedu.tasks.Deadline;
import seedu.tasks.Todo;

public class TodoCommand extends AddCommand {

    private String userInput;

    public TodoCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() throws ProjException {

        String title = getTitle(userInput);

        if (title.length() == 0) {
            throw new ProjException("Please input a title for the todo task.");
        }

        String date = getDate(userInput);
        String description = getDescription(userInput);
        String reminder = getReminder(userInput);
        String time = getTime(userInput);
        String location = getLocation(userInput);

        taskList.addTask(new Deadline(title, description, date, time, location, reminder));
        return new CommandResult("Added todo");
    }

}
