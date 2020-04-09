package seedu.command;

import seedu.exception.ProjException;
import seedu.storage.Storage;
import seedu.tasks.Task;
import seedu.tasks.TaskNonclass;
import seedu.tasks.Class;

import java.util.SortedMap;

import static seedu.common.Constants.CLASS_CATEGORY;
import static seedu.common.Constants.TAB;

public class AddCommand extends Command {

    private String userInput;

    public static final String COMMAND_WORD = "add";
    public static final String COMMAND_USAGE = COMMAND_WORD + " n/[title] i/[description] t/[hh:mm-hh:mm] "
           + "d/[dd-mm-yyyy] l/[LOCATION] r/[REMINDER] c/[CATEGORY]";

    private static final String MESSAGE_SUCCESS = "Nice! Added the following task to the calendar:\n";
    private static final String MESSAGE_CURRENT_TASKS = "Now you have %d task/tasks in your list";


    public AddCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() throws ProjException {

        // Check if the user uses / for time/date format
        if (hasWrongDelimiterPattern(userInput)) {
            throw new ProjException("Please note that / is only used in delimiter : "
                    + "Similar format like 2020/04/16 is not allowed.");
        }

        //Check if user enters title
        String title = getTitle(userInput);
        if (title.length() == 0) {
            throw new ProjException("Please input a title for the task.");
        }

        String date = getDate(userInput);
        String description = getDescription(userInput);
        String reminder = getReminder(userInput);
        String time = getTime(userInput);
        String location = getLocation(userInput);
        String category = getCategory(userInput).trim().toUpperCase();

        //Check date/time format
        checkDateTimeFormat(date,time);

        if (category.equals(CLASS_CATEGORY)) {
            taskList.addTask(new Class(title, description, date, time, location, reminder, "CLASS"));
        } else {
            taskList.addTask(new TaskNonclass(title, description, date, time, location, reminder, category));
        }

        Storage.overwriteFile(taskList.getList());

        String feedback = formatFeedback(taskList.getTask(taskList.getListSize() - 1));

        assert !title.isEmpty() : "Task title should contain at least one char";
        return new CommandResult(feedback);
    }

    private String formatFeedback(Task task) {

        String feedback = MESSAGE_SUCCESS + TAB + TAB + task.toString() + System.lineSeparator()
                + String.format(MESSAGE_CURRENT_TASKS, taskList.getListSize())
                + System.lineSeparator();

        return feedback;
    }

}
