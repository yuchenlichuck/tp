package seedu.parser;

import seedu.command.*;

import static seedu.common.Constants.*;


public class Parser {

    /**
     * Parses user input into command for execution
     *
     * @param userCommand user input including command word and parameters
     * @return  command based on user input
     */
    public static Command parseCommand(String userCommand) {
        //parsing based on first word of command string
        String[] commandSections = userCommand.split(" ");
        int wordLength = commandSections.length;
        switch (commandSections[0]) {
        case "list":
            return new ListCommand();
        case "done":
            // return prepareDoneCommand(commandSections[1], wordLength);
        case "help":
            // return new HelpCommand();
        case "delete":
            // return prepareDeleteCommand(commandSections[1], wordLength);
        case "todo":
            return new AddCommand(userCommand, wordLength,TASK_TODO);
        case "event":
            return new AddCommand(userCommand, wordLength, TASK_EVENT);
        case "deadline":
            return new AddCommand(userCommand, wordLength, TASK_DEADLINE);
        case "find":
            // return new FindCommand(commandSections[1]);
        case "bye":
            return new ExitCommand();
        default:
            System.out.println("Command not recognised\n");
            return new HelpCommand();
        }
    }

}
