package seedu.parser;

import seedu.command.*;

import java.util.Calendar;

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

        case CalendarCommand.COMMAND_WORD:
            if (commandSections.length == 2) {
                return new CalendarCommand(commandSections[1]);
            }
            else if (commandSections.length == 1) {
                return new CalendarCommand(null);
            }

        default:
            System.out.println("Command not recognised\n");
            return new HelpCommand();
        }
    }

    public static boolean isInteger(String date) {
        for (char c : date.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
