package seedu.command;

public class ClearCommand extends Command {

    /** Lines to print to clear out the console. */
    private static final int LINES_TO_PRINT = 100;

    @Override
    public CommandResult execute() {

        String feedback = "";

        for (int i = 0; i < LINES_TO_PRINT; i++) {
            feedback += System.lineSeparator();
        }

        return new CommandResult(feedback);
    }

}
