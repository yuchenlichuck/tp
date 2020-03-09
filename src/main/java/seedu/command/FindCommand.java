package seedu.command;

import seedu.tasks.Task;

import java.util.ArrayList;

public class FindCommand extends Command {

    private String pattern;

    public FindCommand(String pattern) {
        this.pattern = pattern.trim().substring(4);
    }

    public CommandResult execute () {
        ArrayList<Task> tasks = taskList.findTasks(pattern);
        String feedback = "";

        for (int i = 0; i < tasks.size(); i++) {
            feedback += (i+1) + ". " + tasks.get(i) + "\n";
        }

        return new CommandResult(feedback);
    }

}
