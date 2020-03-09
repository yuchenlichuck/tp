package seedu.command;

public class DeleteCommand extends Command {

    private String userInput;

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    public CommandResult execute() {
        String[] commandSections = userInput.split(" ");

        int index = Integer.parseInt(commandSections[1].trim()) - 1;

        taskList.deleteTask(index);

        return new CommandResult("Deleted Task");
    }
}
