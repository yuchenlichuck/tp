package seedu.command;

import seedu.exception.ProjException;

public class EditCommand extends Command {
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
        Boolean isEdit = false;
        if (!isNumeric(taskEdited.trim())) {
            throw new ProjException("Please input a task index.");
        }
        Integer taskEdited = Integer.parseInt(this.taskEdited.trim()) - 1;

        String title = getTitle(userInput);
        if (hasInput(title)) {
            throw new ProjException("Not allowed to change title.");
        }

        String description = getDescription(userInput);
        if (hasInput(description)) {
            taskList.changeDescription(taskEdited,description);
            isEdit = true;
        }

        String reminder = getReminder(userInput);
        if (hasInput(reminder)) {
            taskList.changeReminder(taskEdited,reminder);
            isEdit = true;
        }

        String date = getDate(userInput);
        if (hasInput(date)) {
            taskList.changeDate(taskEdited,date);
            isEdit = true;
        }

        String time = getTime(userInput);
        if (hasInput(time)) {
            taskList.changeTime(taskEdited,time);
            isEdit = true;
        }

        String location = getLocation(userInput);
        if (hasInput(location)) {
            taskList.changeLocation(taskEdited,location);
            isEdit = true;
        }

        String category = getCategory(userInput);
        if (hasInput(category)) {
            taskList.changeCategory(taskEdited,category);
            isEdit = true;
        }

        if(isEdit) {
            String feedback = "Task " + (taskEdited + 1) + " edited\n";
            feedback = feedback + taskList.getTask(taskEdited).toString() + "\n";
            return new CommandResult(feedback);
        } else {
            throw new ProjException("You have not modified any task as no valid field input. ");
        }
    }
}
