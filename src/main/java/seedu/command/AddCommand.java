package seedu.command;

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

    @Override
    /**
     * Add different type of tasks to the taskList.
     */
    public void execute() {
        switch (taskType) {
        case TASK_DEADLINE:
            tasks.addDeadline(userInput, wordArrayLength);
            break;
        case TASK_EVENT:
            tasks.addEvent(userInput, wordArrayLength);
            break;
        case TASK_TODO:
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
