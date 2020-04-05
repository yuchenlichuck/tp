package seedu.parser;

import seedu.command.AddCommand;
import seedu.command.CalendarCommand;
import seedu.command.ClearCommand;
import seedu.command.DeleteCommand;
import seedu.command.DoneCommand;
import seedu.command.EditCommand;
import seedu.command.ExitCommand;
import seedu.command.FindCommand;
import seedu.command.FailedCommand;
import seedu.command.HelpCommand;
import seedu.command.ListCommand;
import seedu.command.Command;

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

        case DoneCommand.COMMAND_WORD:
            if (commandSections.length != 2) {
                return new FailedCommand("[Error][Done]: Wrong number of arguments");
            }
            return new DoneCommand(commandSections[1]);

        case CalendarCommand.COMMAND_WORD:
            if (commandSections.length == 2) {
                return new CalendarCommand(commandSections[1]);
            }
            if (commandSections.length == 1) {
                return new CalendarCommand(null);
            }
            return new FailedCommand("[Error][Calendar]: Please input the right number of arguments");

        default:
            System.out.println("Command not recognised\n");
            return new HelpCommand();
        }
    }


    /**
     * Check if String is a valid integer.
     * @param value Input string for checking
     * @return boolean if string is valid
     */
    public static boolean isInteger(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
