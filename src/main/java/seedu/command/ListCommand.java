package seedu.command;

import seedu.tasks.Task;
import java.util.ArrayList;

public class ListCommand extends Command {

    public CommandResult execute() {

        ArrayList<Task> tasks = taskList.getList();
        String feedback = "";

        feedback += "There are " + tasks.size() + " tasks in your list.\n";

        for (int i = 0; i < tasks.size(); i++) {
            feedback += (i + 1) + ". ";
            feedback += tasks.get(i);
            feedback += "\n";
        }

        return new CommandResult(feedback);
    }

}
