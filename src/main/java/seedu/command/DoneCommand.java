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
    public static final String COMMAND_INFO = COMMAND_WORD + ": changes the status of task to completed";
    public static final String COMMAND_USAGE = COMMAND_WORD + " [TASK_INDEX]";


    public static final String ARGUMENT_COuNT = "1";
    private String feedback = "";

    private String indexCompleteTask;

    public DoneCommand(String indexCompleteTask) {
        this.indexCompleteTask = indexCompleteTask;
    }

    @Override
    public CommandResult execute() throws ProjException {

        try {
            Boolean checkValidNumber = Parser.isInteger(indexCompleteTask);

            if (!checkValidNumber) {
                feedback += TAB + "[Error][Done] Please insert a valid number\n";
                return new CommandResult(feedback);
            }

            if (taskList.getListSize() == 0) {
                feedback += TAB + "[Alert][Done]: There are no tasks to mark completed!\n";
                return new CommandResult(feedback);
            }

            Task task = taskList.getTask(Integer.parseInt(indexCompleteTask) - TASKLIST_OFFSET);

            if (task instanceof TaskNonclass) {
                TaskNonclass taskNonClass = (TaskNonclass) task;
                if (!taskNonClass.getDoneStatus()) {
                    markAsDone(taskNonClass);
                } else {
                    feedback += TAB + "[Alert][Done]: Task is already done\n";
                }
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println(TAB + "[Error][Done]: Please input a task within the range of: 1 - "
                    + taskList.getList().size());
        } catch (NumberFormatException e) {
            System.out.println(TAB + "[Error][Done]: Please input task number as a number, instead "
                    + "of spelling it out.");
        }
        return new CommandResult(feedback);
    }


    private void markAsDone(TaskNonclass task) {
        task.markAsDone();
        feedback += TAB + "Task marked as done: " + NEW_LINE + TAB + TAB;
        feedback += "[" + ((TaskNonclass) task).getStatusIcon() + "] " + task + "\n";
        Storage.overwriteFile(taskList.getList());
    }


}