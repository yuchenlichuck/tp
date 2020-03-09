package seedu.command;

public class ListCommand extends Command {
    public void execute() {
        ui.showTaskList(tasks);
    }
}
