package seedu.command;

import seedu.exception.ProjException;

public class EditCommand extends AddCommand {
    private String taskEdited;
    private String userInput;

    public EditCommand(String taskEdited,String userInput){
        this.taskEdited = taskEdited;
        this.userInput = userInput;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Boolean hasInput(String input) {
        if(input.length() == 0) {
            return false;
        }
        return true;
    }

    public CommandResult execute() throws ProjException {
        if(!isNumeric(taskEdited.trim())) {
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
            taskList.changeTitle(taskEdited, title);
        }
        if(hasInput(description)) {
            taskList.changeDescription(taskEdited,description);
        }

        String feedback = "Task " + (taskEdited + 1) + " edited\n";
        feedback  = feedback + taskList.getTask(taskEdited).toString();
        return new CommandResult(feedback);
    }
}
