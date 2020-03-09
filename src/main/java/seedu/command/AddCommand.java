package seedu.command;

import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasklist.TaskList;
import seedu.ui.Ui;

import static seedu.common.Constants.*;

public class AddCommand extends Command {

    private String userInput;
    private int wordArrayLength;
    private char taskType;

    public AddCommand(String userCommand, int wordArrayLength, char taskType) {
        this.userInput = userCommand;
        this.wordArrayLength  = wordArrayLength;
        this.taskType = taskType;
    }

    /**
     * Checks if the input task format is correct for deadline and event.
     *
     * @return True if it is correct.
     */
    private Boolean isFormatCorrect() {
        String[] inputSections = userInput.split("\\s+");
        int dividerPosition = userInput.indexOf("/");
        if (inputSections.length < 4) {
            /** handle command : command / time*/
            return false;
        } else if (dividerPosition == -1) {
            /** handle command : command task/ time */
             return false;
        } else if (dividerPosition == userInput.length() - 1) {
            /** handle command without time*/
            return false;
        } else if (taskType == TASK_DEADLINE) {
            /** handle command: deadline / time task*/
            int deadlineDividerPosition = userInput.indexOf("/");
            if(deadlineDividerPosition == DEADLINE_LENGTH + 1) {
                return false;
            }
        } else if (taskType == TASK_EVENT) {
            /** handle command: event / time task*/
            int eventDividerPosition = userInput.indexOf("/");
            if(eventDividerPosition == EVENT_LENGTH + 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    /**
     * Adds different types of tasks in list
     */
    public void execute() throws ProjException {
        String[] inputSections = userInput.split("\\s+");
        if (inputSections.length < 2) {
            throw new ProjException("The description of a task cannot be empty.");
        }
        switch (taskType) {
        case TASK_DEADLINE:
            /** Format: deadline tasks / yyyy-mm-dd*/
            if (!isFormatCorrect()) {
                throw new ProjException("Please follow the format: deadline tasks / yyyy-mm-dd");
            }
            tasks.addDeadline(userInput, wordArrayLength);
            break;
        case TASK_EVENT:
            /** Format: event tasks / yyyy-mm-dd*/
            if (!isFormatCorrect()) {
                throw new ProjException("Please follow the format: deadline tasks / yyyy-mm-dd");
            }
            tasks.addEvent(userInput, wordArrayLength);
            break;
        case TASK_TODO:
            /** Format: todo tasks*/
            tasks.addTodo(userInput, wordArrayLength);
            break;
        default:
            System.out.println("[Error][New Task]: Keyword not recognised!\n");
            System.out.println("Task types:\ntodo\nevent\ndeadline");
        }
        /**
         * Can replace the userInput into the task type.
         * E.g. Ui.showAddTask(Task tasks[i]) where i is the index of the newly added tasks
         */
        Ui.showAddTask(userInput,tasks.size());
        //storage.writeToFile(tasks);
    }
}
