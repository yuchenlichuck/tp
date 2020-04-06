package seedu.command;

import seedu.common.Messages;
import seedu.exception.CommandExceptions.EmptyTaskListException;
import seedu.exception.CommandExceptions.TaskOutOfBoundsException;
import seedu.tasks.Task;

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

        String feedback = "";
        String[] commandSections = userInput.split(" ");

        try {

            checkForEmptyList();

            String strIndex = commandSections[1].trim();
            int index = Integer.parseInt(strIndex) - 1;
            checkForValidIndex(index);
            assert index < taskList.getListSize() : "index > the size of taskList";

            Task removedTask = taskList.deleteTask(index);

            storage.overwriteFile(taskList.getList());

            assert removedTask != null : "Removed-task is null";
            feedback = formatSuccessFeedback(removedTask);

        } catch (TaskOutOfBoundsException e) {
            feedback = String.format(Messages.MESSAGE_OUT_OF_BOUNDS, commandSections[1].trim(), taskList.getListSize());

        } catch (IndexOutOfBoundsException e) {
            feedback = Messages.MESSAGE_MISSING_NUMBER;

        } catch (NumberFormatException e) {
            feedback = String.format(Messages.MESSAGE_INVALID_INDEX, commandSections[1]);

        } catch (EmptyTaskListException e) {
            feedback = String.format(Messages.MESSAGE_LIST_IS_EMPTY, COMMAND_WORD);

        } finally {
            return new CommandResult(feedback);
        }
    }

    private void checkForEmptyList() throws EmptyTaskListException {
        if (taskList.getListSize() == 0) {
            throw new EmptyTaskListException();
        }
    }

    private void checkForValidIndex(int index) throws TaskOutOfBoundsException {

        if (index < 0 || index >= taskList.getListSize()) {
            throw new TaskOutOfBoundsException();
        }
    }

    private String formatSuccessFeedback(Task removed) {

        String feedback = "";

        String description = TAB + removed.toString() + System.lineSeparator();
        description += String.format(TAB + Messages.MESSAGE_REMAINING_TASKS, taskList.getListSize());
        description += System.lineSeparator();

        feedback = String.format(Messages.MESSAGE_DELETE_SUCCESS, description);

        return feedback;
    }

}
