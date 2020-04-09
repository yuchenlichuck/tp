package seedu.common;

import seedu.command.AddCommand;
import seedu.command.DeleteCommand;
import seedu.command.FindCommand;

import static seedu.common.Constants.TAB;

/**
 * Container class for repeated static Strings.
 */
public class Messages {


    //    static final String HELP_COMMAND = TAB + "Command List:\n\n";
    //    static final String HELP_EXIT = TAB + TAB + "Exit: Exits program\n" + TAB + TAB + "Usage: bye\n\n";
    //    static final String HELP_LIST = TAB + TAB + "List: Lists all recorded tasks\n"
    //    + TAB + TAB + "Usage: list\n\n";
    //    static final String HELP_ADD = TAB + TAB + "Add: add task\n" + TAB + TAB + "Usage: "
    //            + AddCommand.COMMAND_USAGE + "\n\n";
    //    static final String HELP_DELETE = TAB + TAB + "Delete: Deletes task from list\n" + TAB + TAB + "Usage: "
    //            + DeleteCommand.COMMAND_USAGE + "\n\n";
    //    static final String HELP_FIND = TAB + TAB + "Find: Search for task using keyword\n" + TAB + TAB + "Usage: "
    //            + FindCommand.COMMAND_USAGE + "\n\n";


    // Find Command
    public static final String MESSAGE_SUCCESS = "Found the followings tasks:\n%s";
    public static final String MESSAGE_EMPTY_PATTERN = "[Error][find] Please enter a pattern to look for \n";
    public static final String MESSAGE_NO_FOUND = "[Alert][find] No tasks found with \"%s\" in their title, "
            + "description, or location\n";

    //Delete Command
    public static final String MESSAGE_INVALID_INDEX = "[Error][%s] The entered index \"%s\" is invalid. "
            + "Please enter a valid task number\n";
    public static final String MESSAGE_MISSING_NUMBER = "[Error][delete] Missing task number to delete\n";
    public static final String MESSAGE_REMAINING_TASKS = "Now you have %d task/tasks in your calendar\n";
    public static final String MESSAGE_DELETE_SUCCESS = "The following task has been removed:\n %s";


    public static final String MESSAGE_LIST_IS_EMPTY = "[Alert][%s] There is nothing to %s, the list is empty\n";
    public static final String MESSAGE_OUT_OF_BOUNDS = "[Error][%s] Task number \"%s\" doesn't exit. There are %s"
            + " task/tasks in the list\n";
    public static final String MESSAGE_PRESENT_OR_FUTURE_DATE = "[Alert][list] Please enter a present or future date";


    public static final String MESSAGE_EDIT_MISSING_INDEX = "[Error][edit] Missing task number to edit "
            + "(e.g: edit 2 r/reminder)";
    public static final String MESSAGE_EDIT_TITLE_ERROR = "[Alert][edit] Not allowed to change title";
    public static final String MESSAGE_TASK_TO_CLASS_ERROR = "[Alert][edit] Not allowed to change from "
            + "other categories to CLASS category";
    public static final String MESSAGE_CLASS_TO_TASK_ERROR = "[Alert][edit] Not allowed to change from "
            + "CLASS category to other category";
    public static final String MESSAGE_NO_TASK_MODIFIED = "[Alert][edit] No task has been edited"
            + " (No valid field input)";
    public static final String MESSAGE_DATE_TIME_MISMATCH = "[Alert][edit] The number of time range must match "
            + "with the number of date(day of a week).";


    public static final String MESSAGE_DATETIME_ERROR = TAB + "[Error] Expected format for date/time:"
            + " yyyy-mm-dd; time: hh:mm";

    public static final String BYE_MESSAGE = "CAFS: Bye, hope to see you again!\n";


    //    /**
    //     * Formats the list of available commands.
    //     *
    //     * @return list of supported commands
    //     */
    //    public static String getCommands() {
    //        String fullCommand = HELP_COMMAND + HELP_EXIT + HELP_LIST
    //                + HELP_ADD + HELP_DELETE + HELP_FIND;
    //        return fullCommand;
    //    }

    //    /**
    //     * Gets the legend information for the supported commands.
    //     *
    //     * @return legend information
    //     */
    //    public static String getLegend() {
    //        return HELP_LEGEND;
    //    }
}
