package seedu.command;

import seedu.exception.ProjException;
import seedu.storage.Storage;

import static seedu.common.Constants.CLASS_CATEGORY;

public class EditCommand extends Command {
    private String taskEdited;
    private String userInput;

    public static final String COMMAND_WORD = "edit";
    public static final String COMMAND_INFO = COMMAND_WORD + ": edits the specified task";
    public static final String COMMAND_USAGE = COMMAND_WORD + " TASK_INDEX t/[HH:MM-HH:MM] l/[LOCATION] "
            + "d/[DD-MM-YYYY] i/[INFORMATION] r/[REMINDER] c/[CATEGORY]";

    public EditCommand(String userInput) {
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
        String[] commandSections = this.userInput.split(" ");
        if (commandSections.length < 2) {
            throw new ProjException("Please input a task index. E.g: edit 2 r/reminder");
        }
        this.taskEdited = commandSections[1];
        if (!isNumeric(taskEdited.trim())) {
            throw new ProjException("Please input a task index. E.g: edit 2 r/reminder");
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

        //When both date and time are inputted, need to check the matching format.
        String date = getDate(userInput);
        String time = getTime(userInput);
        checkDateTimeFormat(date,time);
        if (hasInput(date) & hasInput(time)) {
            taskList.changeDate(taskEdited,date);
            taskList.changeTime(taskEdited,time);
            isEdit = true;
        }
        //When only either date/time is inputted, need to check if date&time match after modifying.
        if (hasInput(date) & !hasInput(time)) {
            if (date.split("\\s+").length != taskList.getTask(taskEdited).getTime().size() / 2) {
                throw new ProjException("The number of time range must match with the number of date(day of a week).");
            }
            taskList.changeDate(taskEdited,date);
            isEdit = true;
        }
        if (hasInput(time) & !hasInput(date)) {
            if (time.split("\\s+").length != taskList.getTask(taskEdited).getDate().size()) {
                throw new ProjException("The number of time range must match with the number of date(day of a week).");
            }
            taskList.changeTime(taskEdited,time);
            isEdit = true;
        }

        String location = getLocation(userInput);
        if (hasInput(location)) {
            taskList.changeLocation(taskEdited,location);
            isEdit = true;
        }

        String category = getCategory(userInput).trim().toUpperCase();
        if (hasInput(category)) {
            //If it is class, cannot change to task. If it is task, cannot change to class.
            if (category.equals(CLASS_CATEGORY)) {
                throw new ProjException("Cannot cast a task to class.");
            } else if (taskList.getTask(taskEdited).getCategory().equals(CLASS_CATEGORY)) {
                throw new ProjException("Cannot cast a class to task.");
            }
            taskList.changeCategory(taskEdited,category);
            isEdit = true;
        }

        //post condition for checking no title input.
        assert (!hasInput(title));

        if (isEdit) {
            String feedback = "Task " + (taskEdited + 1) + " edited\n";
            feedback = feedback + taskList.getTask(taskEdited).toString() + "\n";

            Storage.overwriteFile(taskList.getList());

            return new CommandResult(feedback);
        } else {
            throw new ProjException("You have not modified any task as no valid field input. ");
        }
    }
}
