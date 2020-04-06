package seedu.command;

import seedu.exception.ProjException;
import seedu.parser.Parser;
import seedu.storage.Storage;
import seedu.tasks.Task;
import seedu.tasks.TaskNonclass;
import static seedu.common.Constants.TAB;
import static seedu.common.Constants.NEW_LINE;
import static seedu.common.Constants.TASKLIST_OFFSET;


public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";

    private String indexCompleteTask;

    public DoneCommand(String indexCompleteTask) {
        this.indexCompleteTask = indexCompleteTask;
    }

    @Override
    public CommandResult execute() throws ProjException {
        String feedback = "";
        try {
            Boolean checkValidNumber = Parser.isInteger(indexCompleteTask);

            if (!checkValidNumber) {
                feedback += "[Error][Done] Please insert a valid number";
                return new CommandResult(feedback);
            }

            if (taskList.getListSize() == 0) {
                feedback += "[Alert][Done]: There are no tasks to mark completed!";
                return new CommandResult(feedback);
            }

            Task task = taskList.getTask(Integer.parseInt(indexCompleteTask) - TASKLIST_OFFSET);

            if (task instanceof TaskNonclass) {
                ((TaskNonclass) task).markAsDone();
                feedback += "Task marked as done: " + NEW_LINE + TAB + TAB;
                feedback += "[" + ((TaskNonclass) task).getStatusIcon() + "] " + task + "\n";
                if (checkValidNumber) {
                    Storage.overwriteFile(taskList.getList());
                }
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("[Error][Done]: Please input a task within the range of: 1 - "
                    + taskList.getList().size() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("[Error][Done]: Please input task number as a number, instead of spelling it out\n");
        }
        return new CommandResult(feedback);
    }
}