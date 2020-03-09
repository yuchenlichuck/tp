package seedu.command;

import seedu.common.Messages;

public class HelpCommand extends Command {

    @Override
    public CommandResult execute() {
        String legend = Messages.getLegend();
        String commands = Messages.getCommands();

        return new CommandResult(legend + commands);
    }
}
