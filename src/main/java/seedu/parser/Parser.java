package seedu.parser;

import seedu.command.Command;
import seedu.command.AddCommand;
import seedu.command.HelpCommand;
import seedu.command.FindCommand;
import seedu.command.ExitCommand;
import seedu.command.DeleteCommand;
import seedu.command.ListCommand;
import seedu.command.EditCommand;
import seedu.command.ClearCommand;

public class Parser {

    /**
     * Parses user input into command for execution.
     *
     * @param userCommand user input including command word and parameters
     * @return  command based on user input
     */
    public static Command parseCommand(String userCommand) {

        String[] commandSections = userCommand.split(" ");
        String command = commandSections[0].toLowerCase().trim();

        switch (command) {

        case ListCommand.COMMAND_WORD:
            return new ListCommand(userCommand);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommand(userCommand);

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case AddCommand.COMMAND_WORD:
            return new AddCommand(userCommand);

        case FindCommand.COMMAND_WORD:
            return new FindCommand(userCommand);

        case EditCommand.COMMAND_WORD:
            return new EditCommand(commandSections[1], userCommand);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        default:
            System.out.println("Command not recognised\n");
            return new HelpCommand();
        }
    }

}
