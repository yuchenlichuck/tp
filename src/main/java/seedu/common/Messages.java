package seedu.common;

import seedu.command.HelpCommand;

/**
 * Container class for repeated static Strings
 */
public class Messages {
    final static String HELP_COMMAND = "Command List:\n\n";
    final static String HELP_LEGEND = "Legend:\n"
                    + "[Y]: Task is completed\n"
                    + "[N]: Task is not completed\n\n";
    final static String HELP_EXIT = "Exit: Exits program \nUsage: bye\n\n";
    final static String HELP_LIST = "List: Lists all recorded tasks \nUsage: list\n\n";
    final static String HELP_DONE = "Done: Mark task as completed \nUsage: \n\n";
    final static String HELP_TODO = "Todo: Basic Tasks without date/time \nUsage:  \n\n";
    final static String HELP_EVENT = "Event: Event tasks including date/time \nUsage:  \n\n";
    final static String HELP_DEADLINE = "Deadline: Deadline tasks including date/time \nUsage: \n\n";
    final static String HELP_DELETE = "Delete: Deletes task from list \nUsage: \n\n";
    final static String HELP_FIND = "Find: Search for task using keyword \nUsage: \n\n";

    public static String getCommands() {
        String fullCommand = HELP_COMMAND + HELP_EXIT + HELP_LIST + HELP_DONE
                + HELP_TODO + HELP_EVENT + HELP_DEADLINE
                + HELP_DELETE + HELP_FIND;
        return fullCommand;
    }

    public static String getLegend() {
        return HELP_LEGEND;
    }
}
