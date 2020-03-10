package seedu.command;

import seedu.tasks.Deadline;

public class DeadlineCommand extends AddCommand {

    private String userInput;

    public DeadlineCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() {

        String title = getTitle(userInput);
        String date = getDate(userInput);
        String description = getDescription(userInput);

        taskList.addTask(new Deadline(title, description, date));

        return new CommandResult("Added deadline");
    }

}
