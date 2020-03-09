package seedu.command;

/**
 * Sends the exit signal to main loop, program is exited after this command
 */
public class ExitCommand extends Command {

    final String BYE_MESSAGE = "CAFS: Bye, hope to see you again!";

    /**
     * Check if exit command is given
     * @return signal to main loop that program will be terminated
     */
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute() {
        ui.showUserMessage(BYE_MESSAGE);
    }
}

