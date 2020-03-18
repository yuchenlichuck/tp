package seedu.command;

import seedu.exception.ProjException;
import seedu.tasks.Task;

import static seedu.common.Constants.TAB;

public class AddCommand extends Command {

    private String userInput;
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
        String category = getCategory(userInput);

        Task task = new Task(title, description, date, time, location, reminder,category);
        taskList.addTask(task);

        storage.overwriteFile(taskList.getList());

        String feedback = formatFeedback(task);


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
