package seedu.parser;

import seedu.command.*;
import seedu.exception.ProjException;

import static seedu.common.Constants.FIND;
import static seedu.common.Constants.EVENT;
import static seedu.common.Constants.DEADLINE;
import static seedu.common.Constants.TODO;
import static seedu.common.Constants.DELETE;
import static seedu.common.Constants.EXIT;
import static seedu.common.Constants.HELP;
import static seedu.common.Constants.LIST;
import static seedu.common.Constants.EDIT;


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
        //case DONE:
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
        case EDIT:
            return new EditCommand(commandSections[1], userCommand);
        case EXIT:
            return new ExitCommand();
        default:
            System.out.println("Command not recognised\n");
            return new HelpCommand();
        }
    }

}
