package seedu.command;

import seedu.common.Messages;
import seedu.tasks.Task;

import java.util.IllegalFormatException;

import static seedu.common.Constants.TAB;

public class DeleteCommand extends Command {

    private String userInput;

    public static final String COMMAND_WORD = "delete";
    public static final String COMMAND_USAGE = COMMAND_WORD + " [task number]";


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
            taskList.deleteCategory(index, removedTask.getCategory());
            storage.overwriteFile(taskList.getList());
            assert removedTask != null : "Removed-task is null";
            return new CommandResult(formatFeedback(removedTask));

        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(Messages.MESSAGE_MISSING_NUMBER);

        } catch (IllegalFormatException e) {
            String feedback = String.format(Messages.MESSAGE_INVALID_INDEX, commandSections[1]);
            return new CommandResult(feedback);

        }
    }

    private String formatFeedback(Task removed) {

        String feedback = "";

        String description = TAB + removed.toString() + System.lineSeparator();
        description += String.format(TAB + Messages.MESSAGE_REMAINING_TASKS, taskList.getListSize());
        description += System.lineSeparator();

        feedback = String.format(Messages.MESSAGE_DELETE_SUCCESS, description);

        return feedback;
    }

}
