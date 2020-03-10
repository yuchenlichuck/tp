package seedu.command;

import seedu.tasks.Deadline;
import seedu.tasks.Todo;

public class TodoCommand extends AddCommand {

    private String userInput;

    public TodoCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() {

        String title = getTitle(userInput);
        String description = getDescription(userInput);

        taskList.addTask(new Todo(title, description));

        return new CommandResult("Added todo");
    }

}
