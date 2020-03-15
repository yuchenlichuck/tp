package seedu.command;

import seedu.exception.ProjException;

public class EditCommand extends AddCommand {
    private String taskEdited;
    private String userInput;

    public EditCommand(String taskEdited,String userInput) {
        this.taskEdited = taskEdited;
        this.userInput = userInput;
    }

    /**
     * Checks if a string can be casted to a number.
     *
     * @param str input string.
     * @return true if it can be casted.
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if the user has input that field.
     *
     * @param input a field.
     * @return true if user has input that field.
     */
    private Boolean hasInput(String input) {
        if (input.length() == 0) {
            return false;
        }
        return true;
    }

    /**
     * Edit a task by the task index number.
     * Cannot edit title of a class.
     *
     * @return result of command.
     * @throws ProjException if input invalid task index.
     */
    public CommandResult execute() throws ProjException {
        if (!isNumeric(taskEdited.trim())) {
            throw new ProjException("Please input a task index.");
        }
        Integer taskEdited = Integer.parseInt(this.taskEdited.trim()) - 1;

        String title = getTitle(userInput);
        String description = getDescription(userInput);
        String date = getDate(userInput);
        String reminder = getReminder(userInput);
        String time = getTime(userInput);
        String location = getLocation(userInput);

        if (hasInput(title)) {
            throw new ProjException("Not allowed to change title.");
        }

        if (hasInput(description)) {
            taskList.changeDescription(taskEdited,description);
        }

        if (hasInput(reminder)) {
            taskList.changeReminder(taskEdited,reminder);
        }

        if (hasInput(date)) {
            taskList.changeDate(taskEdited,date);
        }

        if (hasInput(time)) {
            taskList.changeTime(taskEdited,time);
        }

        if (hasInput(location)) {
            taskList.changeLocation(taskEdited,location);
        }

        String feedback = "Task " + (taskEdited + 1) + " edited\n";
        feedback  = feedback + taskList.getTask(taskEdited).toString();
        return new CommandResult(feedback);
    }
}
