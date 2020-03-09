package seedu.parser;

import seedu.command.*;
import seedu.tasks.Todo;

import static seedu.common.Constants.*;


public class Parser {

    /**
     * Parses user input into command for execution.
     *
     * @param userCommand user input including command word and parameters
     * @return  command based on user input
     */
    public static Command parseCommand(String userCommand) {

        // parsing based on first word of command string
        String[] commandSections = userCommand.split(" ");
        int wordLength = commandSections.length;

        switch (commandSections[0]) {
        case LIST:
            return new ListCommand();
        case DONE:
            // return prepareDoneCommand(commandSections[1], wordLength);
        case HELP:
            return new HelpCommand();
        case DELETE:
            return new DeleteCommand(userCommand);
        case TODO:
            return new TodoCommand(userCommand);
        case EVENT:
            return new EventCommand(userCommand);
        case DEADLINE:
            return new DeadlineCommand(userCommand);
        case FIND:
            return new FindCommand(userCommand);
        case EXIT:
            return new ExitCommand();
        default:
            System.out.println("Command not recognised\n");
            return new HelpCommand();
        }
    }

}
