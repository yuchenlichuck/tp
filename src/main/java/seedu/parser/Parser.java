package seedu.parser;

import seedu.command.Command;

public class Parser {

    /**
     * Parses user input into command for execution
     *
     * @param userCommand user input including command word and parameters
     * @return  command based on user input
     */
    public static Command parseCommand(String userCommand) {
        //parsing based on first word of command string
        String[] words = userCommand.split(" ");
        int wordLength = words.length;
        switch (words[0]) {
        case "list":
            // return new ListCommand();
        case "done":
            // return prepareDoneCommand(words[1], wordLength);
        case "help":
            // return new HelpCommand();
        case "delete":
            // return prepareDeleteCommand(words[1], wordLength);
        case "todo":
            // return new AddCommand(userCommand, wordLength, TASK_TODO);
        case "event":
            // return new AddCommand(userCommand, wordLength, TASK_EVENT);
        case "deadline":
            // return new AddCommand(userCommand, wordLength, TASK_DEADLINE);
        case "find":
            // return new FindCommand(words[1]);
        case "bye":
            // return new ExitCommand();

        default:
            System.out.println("Command not recognised\n");
            return new HelpCommand();
        }
    }

}
