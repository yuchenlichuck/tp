package seedu.command;

import seedu.exception.ProjException;

public class FailedCommand extends Command {
    private String feedback;

    public FailedCommand (String feedback) {
        this.feedback = feedback;
    }

    @Override
    public CommandResult execute() throws ProjException {
        return new CommandResult(feedback);
    }
}
