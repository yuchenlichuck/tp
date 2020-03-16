package seedu.command;

import seedu.tasks.Task;
import java.util.ArrayList;

public class ListCommand extends Command {

    @Override
    public CommandResult execute() {

        ArrayList<Task> tasks = taskList.getList();

        String feedback = "There are " + tasks.size() + " tasks in your list.\n";

        for (int i = 0; i < tasks.size(); i++) {
            feedback += "\t" + (i + 1) + ". ";
            feedback += tasks.get(i);
            feedback += "\n";
        }

        return new CommandResult(feedback);
    }

}
