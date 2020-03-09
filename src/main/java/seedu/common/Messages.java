package seedu.common;

import seedu.command.HelpCommand;

import static seedu.common.Constants.*;

/**
 * Container class for repeated static Strings.
 */
public class Messages {

    static final String HELP_COMMAND = "Command List:\n\n";
    static final String HELP_LEGEND = "Legend:\n"
                    + "[Y]: Task is completed\n"
                    + "[N]: Task is not completed\n\n";
    static final String HELP_EXIT = "Exit: Exits program \nUsage: bye\n\n";
    static final String HELP_LIST = "List: Lists all recorded tasks \nUsage: list\n\n";
    static final String HELP_DONE = "Done: Mark task as completed \nUsage: \n\n";
    static final String HELP_TODO = "Todo: Basic Tasks without date/time \nUsage: " + EVENT_USAGE + "\n\n";
    static final String HELP_EVENT = "Event: Event tasks including date/time \nUsage: " + EVENT_USAGE + "\n\n";
    static final String HELP_DEADLINE = "Deadline: Deadline tasks including date/time \nUsage: " + DEADLINE_USAGE + "\n\n";
    static final String HELP_DELETE = "Delete: Deletes task from list \nUsage: " + DELETE_USAGE + "\n\n";
    static final String HELP_FIND = "Find: Search for task using keyword \nUsage: " + FIND_USAGE + "\n\n";


    /**
     * Formats the list of available commands.
     *
     * @return list of supported commands
     */
    public static String getCommands() {
        String fullCommand = HELP_COMMAND + HELP_EXIT + HELP_LIST + HELP_DONE
                + HELP_TODO + HELP_EVENT + HELP_DEADLINE
                + HELP_DELETE + HELP_FIND;
        return fullCommand;
    }

    /**
     * Gets the legend information for the supported commands.
     *
     * @return legend information
     */
    public static String getLegend() {
        return HELP_LEGEND;
    }
}
