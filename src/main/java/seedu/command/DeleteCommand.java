package seedu.command;

import seedu.tasks.Task;

import java.util.IllegalFormatException;

public class DeleteCommand extends Command {

    private String userInput;

    private static final String MESSAGE_SUCCESS = "The following task has been removed: %s";
    private static final String MESSAGE_INVALID_INDEX = "The entered index %s is invalid. + "
            + "Please enter a valid task number";
    private static final String MESSAGE_MISSING_NUMBER = "Missing task number to delete";
    private static final String MESSAGE_REMAINING_TASKS = "Now you have %d in your calendar";

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public CommandResult execute() {

        String[] commandSections = userInput.split(" ");;

        try {

            String strIndex = commandSections[1].trim();
            int index = Integer.parseInt(strIndex) - 1;
            Task removedTask = taskList.deleteTask(index);
            storage.overwriteFile(taskList.getList());
            return new CommandResult(formatFeedback(removedTask));

        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(MESSAGE_MISSING_NUMBER);

        } catch (IllegalFormatException e) {
            String feedback = String.format(MESSAGE_INVALID_INDEX, commandSections[1]);
            return new CommandResult(feedback);

        }
    }

    private String formatFeedback(Task removed) {

        String feedback = MESSAGE_SUCCESS + System.lineSeparator();
        feedback += "\t" + removed.toString() + System.lineSeparator();
        feedback += String.format(MESSAGE_REMAINING_TASKS, taskList.getListSize());

        return feedback;
    }

}
