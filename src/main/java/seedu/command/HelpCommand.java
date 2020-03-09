package seedu.command;

import seedu.common.Messages;

public class HelpCommand extends Command{

    @Override
    public void execute() {
        String legend = Messages.getLegend();
        String commands = Messages.getCommands();
        ui.showUserMessage(commands, legend);
    }
}
