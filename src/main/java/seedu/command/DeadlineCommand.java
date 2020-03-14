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
        String reminder = getReminder(userInput);
        String time = getTime(userInput);
        String location = getLocation(userInput);

        taskList.addTask(new Deadline(title, description, date, time, location, reminder));

        return new CommandResult("Added deadline");
    }

}
