package seedu.command;

import seedu.common.Constants;
import seedu.exception.ProjException;

public class FailedCommand extends Command {

    private String feedback = "";


    private final String WRONG_ARGUMENT = "Wrong number of arguments";

    // for error with unique feedback
    public FailedCommand(String commandName, String feedback) {
        feedback += String.format("[Error][%s]: ",commandName);
        this.feedback = feedback;
        this.feedback += Constants.NEW_LINE;
    }

    // for error with arg error
    public FailedCommand(String commandName, int userArgumentCount, String expectedCount ) {
        feedback += String.format("[Error][%s]: %s,\nReceived: %d Expected: %s\n",commandName, WRONG_ARGUMENT, userArgumentCount, expectedCount);
    }

    @Override
    public CommandResult execute() throws ProjException {
        return new CommandResult(feedback);
    }
}
