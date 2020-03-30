package seedu.command;

import seedu.exception.ProjException;
import seedu.tasks.Task;
import seedu.tasks.TaskNonclass;
import seedu.tasks.Class;

import static seedu.common.Constants.TAB;

public class AddCommand extends Command {

    private String userInput;

    public static final String COMMAND_WORD = "add";
    public static final String COMMAND_USAGE = COMMAND_WORD + "n/[title] i/[description] t/[hh:mm] "
           + "d/[yyyy-mm-dd] l/[LOCATION] r/[REMINDER] c/[CATEGORY]";

    private static final String MESSAGE_SUCCESS = "Nice! Added the following task to the calendar:\n";
    private static final String MESSAGE_CURRENT_TASKS = "Now you have %d task/tasks in your list";


    public AddCommand(String userInput) {
        this.userInput = userInput.trim();
    }

    @Override
    public CommandResult execute() throws ProjException {

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


        if (category.equals("CLASS")) {
            Integer dateCount = date.split("\\s+").length;
            Integer timeCount = time.split("\\s+").length;
            if (dateCount != timeCount) {
                throw new ProjException("The number of time range must match with the number of day in a week.");
            }
            taskList.addTask(new Class(title, description, date, time, location, reminder, "CLASS"));
        } else {
            taskList.addTask(new TaskNonclass(title, description, date, time, location, reminder, category));
        }

        String feedback = formatFeedback(taskList.getTask(taskList.getListSize() - 1));


        assert !title.isEmpty() : "Task title should contain at least one char";
        return new CommandResult(feedback);
    }

    private String formatFeedback(Task task) {

        String feedback = MESSAGE_SUCCESS + TAB + TAB + task.toString() + System.lineSeparator()
                + TAB + String.format(MESSAGE_CURRENT_TASKS, taskList.getListSize())
                + System.lineSeparator();

        return feedback;
    }

}
