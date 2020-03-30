package seedu.command;

import seedu.tasks.Task;

import java.util.IllegalFormatException;

import static seedu.common.Constants.TAB;

public class DeleteCommand extends Command {

    private String userInput;

    private static final String MESSAGE_SUCCESS = "The following task has been removed:\n %s";
    private static final String MESSAGE_INVALID_INDEX = "The entered index %s is invalid. + "
            + "Please enter a valid task number\n";
    private static final String MESSAGE_MISSING_NUMBER = "Missing task number to delete\n";
    private static final String MESSAGE_REMAINING_TASKS = "Now you have %d task/tasks in your calendar\n";

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public CommandResult execute() {

        String[] commandSections = userInput.split(" ");

        try {
            String strIndex = commandSections[1].trim();
            int index = Integer.parseInt(strIndex) - 1;
            assert index < taskList.getListSize() : "index > the size of taskList";
            Task removedTask = taskList.deleteTask(index);

            storage.overwriteFile(taskList.getList());
            assert removedTask != null : "Removed-task is null";
            return new CommandResult(formatFeedback(removedTask));

        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(MESSAGE_MISSING_NUMBER);

        } catch (IllegalFormatException e) {
            String feedback = String.format(MESSAGE_INVALID_INDEX, commandSections[1]);
            return new CommandResult(feedback);

        }
    }

    private String formatFeedback(Task removed) {

        String feedback = "";

        String description = TAB + removed.toString() + System.lineSeparator();
        description += String.format(TAB + MESSAGE_REMAINING_TASKS, taskList.getListSize());
        description += System.lineSeparator();

        feedback = String.format(MESSAGE_SUCCESS, description);

        return feedback;
    }

}
