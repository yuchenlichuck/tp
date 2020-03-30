package seedu.common;

import seedu.command.AddCommand;
import seedu.command.DeleteCommand;
import seedu.command.FindCommand;

import static seedu.common.Constants.TAB;

/**
 * Container class for repeated static Strings.
 */
public class Messages {

    static final String HELP_COMMAND = TAB + "Command List:\n\n";

    static final String HELP_EXIT = TAB + TAB + "Exit: Exits program\n" + TAB + TAB + "Usage: bye\n\n";

    static final String HELP_LIST = TAB + TAB + "List: Lists all recorded tasks\n" + TAB + TAB + "Usage: list\n\n";

    static final String HELP_ADD = TAB + TAB + "Add: add task\n" + TAB + TAB + "Usage: "
            + AddCommand.COMMAND_USAGE + "\n\n";

    static final String HELP_DELETE = TAB + TAB + "Delete: Deletes task from list\n" + TAB + TAB + "Usage: "
            + DeleteCommand.COMMAND_USAGE + "\n\n";

    static final String HELP_FIND = TAB + TAB + "Find: Search for task using keyword\n" + TAB + TAB + "Usage: "
            + FindCommand.COMMAND_USAGE + "\n\n";

    static final String HELP_LEGEND = "Legend:\n" + TAB + TAB + "[Y]: Task is completed\n"
            + TAB + TAB +  "[N]: Task is not completed\n\n";

    /**
     * Formats the list of available commands.
     *
     * @return list of supported commands
     */
    public static String getCommands() {
        String fullCommand = HELP_COMMAND + HELP_EXIT + HELP_LIST
                + HELP_ADD + HELP_DELETE + HELP_FIND;
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
