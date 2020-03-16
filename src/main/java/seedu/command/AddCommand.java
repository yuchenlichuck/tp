package seedu.command;

import seedu.exception.ProjException;
import seedu.tasks.Task;

public class AddCommand extends Command {

    private String userInput;

    public AddCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() throws ProjException {

        String title = getTitle(userInput);

        if (title.length() == 0) {
            throw new ProjException("Please input a title for the task.");
        }

        String date = getDate(userInput);
        String description = getDescription(userInput);
        String reminder = getReminder(userInput);
        String time = getTime(userInput);
        String location = getLocation(userInput);
        String category = getCategory(userInput);

        taskList.addTask(new Task(title, description, date, time, location, reminder,category));

        return new CommandResult("Added a task.\n");
    }

}
